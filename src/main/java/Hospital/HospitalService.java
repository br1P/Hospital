package Hospital;
//region import
import Hospital.Exceptions.*;
import Hospital.Models.ClinicalData.Apointment;
import Hospital.Models.ClinicalData.HospitalData;
import Hospital.Models.ClinicalData.Medication;
import Hospital.Models.ClinicalData.Treatment;
import Hospital.Models.People.Medic;
import Hospital.Models.People.Pacient;
import Hospital.enums.Specialty;

import java.lang.reflect.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;
//endregion import

// Functional interfaces for lambda usage
@FunctionalInterface
interface SearchFunction<T, U> {
    T findById(U id);
}

@FunctionalInterface
interface Validator<T> {
    boolean validate(T t);
}

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class HospitalService {
    private HospitalData hospitalData;
    private static final Logger logger = Logger.getLogger(HospitalService.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("hospital.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to set up logger file handler", e);
        }
    }

    public HospitalService(HospitalData hospitalData) {
        this.hospitalData = hospitalData;
    }

    public void startProgram() {
        MenuService menuService = new MenuService(this); // Send hospitalService instance
        menuService.mainMenu();
    }

    // Lambda for finding a pacient by ID
    SearchFunction<Pacient, Integer> findPacientLambda = (id) -> {
        Pacient pacient = hospitalData.getPacients().get(id);
        if (pacient == null) {
            throw new PacientNotFoundException(id);
        }
        return pacient;
    };

    // Lambda for finding a medic by ID
    SearchFunction<Medic, Integer> findMedicLambda = (id) -> hospitalData.getMedics().stream()
            .filter(m -> m.getLicenseNumber() == id)
            .findFirst()
            .orElseThrow(() -> new MedicNotFoundException(id));

    // Lambda for validating a date
    Validator<String> isValidDateLambda = (date) -> {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        try {
            LocalDateTime.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    };

    // Lambda for checking if an appointment exists
    TriFunction<String, Integer, Integer, Boolean> appointmentExistsLambda = (date, pacientId, medicId) -> {
        Pacient pacient = findPacientLambda.findById(pacientId);
        return pacient.getClinicalHistory().getApointments().stream()
                .anyMatch(ap -> ap.getDate().equals(date) && ap.getMedic().getLicenseNumber() == medicId);
    };

    public void viewAllMedics() {
        Set<Medic> medics = hospitalData.getMedics();
        System.out.println("=== All Medics ===");
        for (Medic medic : medics) {
            System.out.println(medic);
        }
    }

    public void viewAllPacients() {
        Map<Integer, Pacient> pacients = hospitalData.getPacients();
        System.out.println("=== All Pacients ===");
        for (Pacient pacient : pacients.values()) {
            System.out.println(pacient);
        }
    }

    public void viewAllPacientsNameID() {
        Map<Integer, Pacient> pacients = hospitalData.getPacients();
        System.out.println("=== All Pacients ===");
        for (Pacient pacient : pacients.values()) {
            System.out.println("name: " + pacient.getName() + " " + pacient.getLastname() + " | ID: " + pacient.getPacientID());
        }
    }

    public void newApointment() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please choose pacient by ID: ");
        viewAllPacientsNameID();
        int idPacient = scanner.nextInt();
        scanner.nextLine();

        try {
            // Use lambda to find pacient
            Pacient pacient = findPacientLambda.findById(idPacient);

            System.out.print("Please specify the date of the apointment (dd/MM/yyyy HH:mm): ");
            String date = scanner.nextLine();

            // Use lambda to validate the date
            if (!isValidDateLambda.validate(date)) {
                throw new InvalidDateException(date);
            }

            System.out.print("Please specify Medics ID: ");
            int idMedic = scanner.nextInt();
            scanner.nextLine();

            // Use lambda to find medic
            Medic medic = findMedicLambda.findById(idMedic);

            // Use lambda to check if the appointment already exists
            if (appointmentExistsLambda.apply(date, idPacient, idMedic)) {
                throw new DuplicateAppointmentException(date, idPacient, idMedic);
            }

            Apointment apointment = new Apointment(date, medic);
            pacient.getClinicalHistory().addApointment(apointment);

            System.out.println("Apointment added successfully to clinic history of pacient with ID: " + idPacient);
        } catch (PacientNotFoundException | MedicNotFoundException e) {
            logger.log(Level.SEVERE, "Exception occurred: ", e);
            System.out.println(e.getMessage());
        }
    }

    public void newTreatment() {
        Scanner scanner = new Scanner(System.in);

        // id client
        System.out.print("Please choose pacient by ID: ");
        viewAllPacientsNameID();
        int idPacient = scanner.nextInt();
        scanner.nextLine();
        try {
            // Use lambda to find pacient
            Pacient pacient = findPacientLambda.findById(idPacient);

            System.out.print("Please write treatment observations: ");
            String observation = scanner.nextLine();

            System.out.print("Please write medication name: ");
            String medName = scanner.nextLine();

            System.out.print("Please write medication dosage: ");
            String medDosage = scanner.nextLine();

            // Create treatment and medication
            Medication medication = new Medication(medName, medDosage);
            Treatment treatment = new Treatment(observation, medication);

            // Add treatment to the patient's clinic history
            pacient.getClinicalHistory().addTreatment(treatment);

            System.out.println("Treatment added successfully to clinic history of pacient with ID: " + idPacient);
        } catch (PacientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Medic> filterMedicsForSpecialty(String specialty) {
        return hospitalData.getMedics().stream()
                .filter(m -> m.getSpecialty().equals(specialty)) //not terminal
                .collect(Collectors.toList()); // terminal
    }

    public List<String> PacientNames() {
        return hospitalData.getPacients().values().stream()
                .map(Pacient::getName) // not terminal
                .collect(Collectors.toList()); //terminal
    }

    public void PrintMedicNames() {
        hospitalData.getMedics().stream()
                .forEach(medic -> System.out.println(medic.getName())); // terminal
    }

    public List<Pacient> orderPacientsByAge() {
        return hospitalData.getPacients().values().stream()
                .sorted(Comparator.comparing(Pacient::getAge)) // not terminal
                .collect(Collectors.toList()); //  terminal
    }

    public List<String> filterPacientsByGender(String gender) {
        return hospitalData.getPacients().values().stream()
                .filter(p -> p.getGender().equalsIgnoreCase(gender)) //not terminal
                .map(Pacient::getName) // not terminal
                .collect(Collectors.toList()); //  terminal
    }



    public void obtainClassDetails() {
        try {
            // get class object from medic
            Class<?> medicClass = Class.forName("Hospital.Models.People.Medic");

            // print modifiers
            int classModifiers = medicClass.getModifiers();
            System.out.println("Class modifiers: " + Modifier.toString(classModifiers));

            // print constructor
            Constructor<?>[] constructors = medicClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Constructor: " + constructor);
                System.out.println("constructor parameters:");
                for (Parameter parameter : constructor.getParameters()) {
                    System.out.println("- " + parameter.getName() + ": " + parameter.getType().getSimpleName());
                }
            }

            // print class methods
            Method[] methods = medicClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method.getName());
                System.out.println("Modifier: " + Modifier.toString(method.getModifiers()));
                System.out.println("Return type: " + method.getReturnType().getSimpleName());
                System.out.println("Parameters:");
                for (Parameter parameter : method.getParameters()) {
                    System.out.println("- " + parameter.getName() + ": " + parameter.getType().getSimpleName());
                }
            }


            Field[] fields = medicClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Fields: " + field.getName() + " (" + field.getType().getSimpleName() + ")");
                System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Medic createNUseMedicWithReflection() {
        try {
            // create medic object with reflex
            Class<?> medicClass = Class.forName("Hospital.Models.People.Medic");
            Constructor<?> constructor = medicClass.getConstructor(String.class, String.class, double.class, int.class, Specialty.class);


            Medic nuevoMedic = (Medic) constructor.newInstance("Max", "Verstapen", 15.0, 40, Specialty.CARDIOLOGY);   // Create a new medic with data

            // return Medic to sendit to the set
            return nuevoMedic;

        } catch (Exception e) {
            e.printStackTrace();
            return null;  // if error returns null
        }
    }


    public HospitalData getHospitalData() {
        return hospitalData;
    }

}
