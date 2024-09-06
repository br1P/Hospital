import Hospital.DefaultDataService;
import Hospital.HospitalService;
import Hospital.Models.ClinicalData.HospitalData;

public class Main {
    public static void main(String[] args) {


        HospitalData hospitalData = DefaultDataService.generateDefaultHospital(); // Generate data


        HospitalService hospitalService = new HospitalService(hospitalData);  // Create an instance with the data generated


        hospitalService.startProgram();
    }
}