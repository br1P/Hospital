package Hospital;

import Hospital.Exceptions.*;
import Hospital.Models.ClinicalData.Apointment;
import Hospital.Models.ClinicalData.HospitalData;
import Hospital.Models.ClinicalData.Medication;
import Hospital.Models.ClinicalData.Treatment;
import Hospital.Models.People.Medic;
import Hospital.Models.People.Pacient;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HospitalService {
    private HospitalData hospitalData;
    private static final Logger logger = Logger.getLogger(HospitalService.class.getName());

    static {         //STATIC BLOCK
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
            System.out.println("name: " +pacient.getName() +" "+ pacient.getLastname() + " | ID: "+ pacient.getPacientID());
        }
    }

    public void newApointment(){
        Scanner scanner = new Scanner(System.in);


        System.out.print("Please choose pacient by ID: ");
        viewAllPacientsNameID();
        int idPacient = scanner.nextInt();
        scanner.nextLine();
        try {

            Pacient pacient = findPacientById(idPacient);

            System.out.print("Please specify the date of the apointment: ");
            String date = scanner.nextLine();

            if (!isValidDate(date)) {
                throw new InvalidDateException(date);
            }

            System.out.print("Please specify Medics ID: ");
            int idMedic = scanner.nextInt();
            Medic medic = findMedicById(idMedic);

            if (appointmentExists(date, idPacient, idMedic)) {
                throw new DuplicateAppointmentException(date, idPacient, idMedic);
            }

            Apointment apointment = new Apointment(date, medic);

            if (date.isEmpty()||medic == null||pacient == null) {
                throw new InsufficientDataException("Date, medic, or pacient data is missing.");
            }

            pacient.getClinicalHistory().addApointment(apointment);

            System.out.println("Apointment added successfully to clinic history of pacient with ID: " + idPacient);
        } catch (PacientNotFoundException  | MedicNotFoundException e) {
            logger.log(Level.SEVERE, "Exception occurred: ", e);
            System.out.println(e.getMessage());
        }
    }


    public void newTreatment(){
        Scanner scanner = new Scanner(System.in);

        // id client
        System.out.print("Please choose pacient by ID: ");
        viewAllPacientsNameID();
        int idPacient = scanner.nextInt();
        scanner.nextLine();
        try {

            Pacient pacient = findPacientById(idPacient);



            System.out.print("Please write treatment observations: ");
            String observation = scanner.nextLine();

            System.out.print("Please write medication name: ");
            String medName = scanner.nextLine();

            System.out.print("Please write medication dosage: ");
            String medDosage = scanner.nextLine();

            // Create treatment and medication
            Medication medication = new Medication(medName, medDosage);
            Treatment treatment = new Treatment(observation, medication);

            // add el treatment to the clients clinic history
            pacient.getClinicalHistory().addTreatment(treatment);

            System.out.println("Treatment added successfully to clinic history of pacient with ID: " + idPacient);
        } catch (PacientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private Pacient findPacientById(int idPacient) {
        Pacient pacient = hospitalData.getPacients().get(idPacient);
        if (pacient == null) {
            throw new PacientNotFoundException(idPacient);
        }
        return pacient;
    }


    private Medic findMedicById(int idMedic) {
        for (Medic m : hospitalData.getMedics()) {
            if (m.getLicenseNumber() == idMedic) {
                return m;
            }
        }
        throw new MedicNotFoundException(idMedic);
    }

    private boolean appointmentExists(String date, int pacientId, int medicId) {

        Pacient pacient = findPacientById(pacientId);

        for (Apointment apointment : pacient.getClinicalHistory().getApointments()) {
            if (apointment.getDate().equals(date) && apointment.getMedic().getLicenseNumber() == medicId) {
                return true;
            }
        }

        return false;
    }

    private boolean isValidDate(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try {

            LocalDateTime parsedDate = LocalDateTime.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
