import Hospital.DefaultDataService;
import Hospital.HospitalService;
import Hospital.Models.ClinicalData.HospitalData;

public class Main {
    public static void main(String[] args) {

        // Generar los datos predeterminados del hospital
        HospitalData hospitalData = DefaultDataService.generateDefaultHospital();

        // Crear una instancia de HospitalService con los datos generados
        HospitalService hospitalService = new HospitalService(hospitalData);

        // Iniciar el programa
        hospitalService.startProgram();
    }
}