package Hospital.Exceptions;

public class MedicNotFoundException extends RuntimeException{
    public MedicNotFoundException(int idMedic) {
        super("Medic with ID " + idMedic + " not found.");
    }
}