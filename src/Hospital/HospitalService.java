package Hospital;

import Hospital.Models.ClinicalData.HospitalData;
import Hospital.Models.ClinicalData.Medication;
import Hospital.Models.ClinicalData.Treatment;
import Hospital.Models.People.Medic;
import Hospital.Models.People.Pacient;

import java.util.List;
import java.util.Scanner;

public class HospitalService {
    private HospitalData hospitalData;

    public HospitalService(HospitalData hospitalData) {
        this.hospitalData = hospitalData;
    }

    public void startProgram() {
        MenuService menuService = new MenuService(this); // Send hospitalService instance
        menuService.mainMenu();
    }

    public void viewAllMedics() {
        List<Medic> medics = hospitalData.getMedics();
        System.out.println("=== All Medics ===");
        for (Medic medic : medics) {
            System.out.println(medic);
        }
    }

    public void viewAllPacients() {
        List<Pacient> pacients = hospitalData.getPacients();
        System.out.println("=== All Pacients ===");
        for (Pacient pacient : pacients) {
            System.out.println(pacient);
        }
    }

    public void newTreatment(){
        Scanner scanner = new Scanner(System.in);

        // id client
        System.out.print("Please choose pacient by ID: ");
        int idPacient = scanner.nextInt();
        scanner.nextLine();

        // look for pacient id
        Pacient pacient = null; //ADD TO AN INTERFACE                         TO DO
        for (Pacient p : hospitalData.getPacients()) {
            if (p.getPacientID() == idPacient) {
                pacient = p;
                break;
            }
        }

        if (pacient == null) { //NOT FOUND EXCEPTION                                TO DO
            System.out.println("Pacient not found.");
            return;
        }

        // add treatment data
        System.out.print("Please write treatment observations: ");
        String observation = scanner.nextLine();

        System.out.print("Please write medication name: ");
        String medName = scanner.nextLine();

        System.out.print("Please write medication dosage: ");
        String medDosage = scanner.nextLine();

        // Create treatment and medication
        Medication medication = new Medication(medName,medDosage);
        Treatment treatment = new Treatment(observation, medication);

        // add el treatment to the clients clinic history
        pacient.getClinicalHistory().addTreatment(treatment);

        System.out.println("Treatment added sucsesfully to clinic history of pacient with ID: " + idPacient);
    }
}
