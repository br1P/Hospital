package Hospital;

import java.util.Date;
import java.util.Scanner;

final public class MenuService {
    private static HospitalService hospitalService;

    static{
        Date logtime= new Date();
        System.out.println("====Welcome====");
        System.out.println("Logged today at:" + logtime);
    }

    public MenuService(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;



        do {
            System.out.println("=== Pacient Manager ===");
            System.out.println("1.  Make an appointment");
            System.out.println("2.  Make a Treatment");
            System.out.println("3.  Administration CRUD options");
            System.out.println("4. View data");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    //makeApointmentMenu();
                    break;
                case 2:
                    viewTreatmentMenu();
                    break;
                case 3:
                    //option3();
                    break;
                case 4:
                    viewDataMenu();
                    break;
                case 5:
                    System.out.println("Leaving the app...");
                    break;
                default:
                    System.out.println("Option not valid. Please choose another one");
            }

            System.out.println();

        } while (option != 5);

        scanner.close();
    }

    public static void viewTreatmentMenu(){

        System.out.println("==NEW treatment==");
        hospitalService.newTreatment();


    }
    public static void viewDataMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== View Data ===");
            System.out.println("1. View all Medics");
            System.out.println("2. View all Pacients");
            System.out.println("3. Back to previous menu");
            System.out.print("Select an option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    hospitalService.viewAllMedics();
                    break;
                case 2:
                    hospitalService.viewAllPacients();
                    break;
                case 3:
                    System.out.println("Returning to previous menu...");
                    break;
                default:
                    System.out.println("Option not valid. Please choose another one");
            }

            System.out.println();

        } while (option != 3);
    }
    }


