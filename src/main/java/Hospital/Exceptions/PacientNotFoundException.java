package Hospital.Exceptions;

public class PacientNotFoundException extends RuntimeException{
    public PacientNotFoundException(int idPacient) {
        super("Pacient with ID " + idPacient + " not found.");
    }
}
