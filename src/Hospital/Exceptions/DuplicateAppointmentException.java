package Hospital.Exceptions;

public class DuplicateAppointmentException extends RuntimeException {
    public DuplicateAppointmentException(String date, int pacientId, int medicId) {
        super("Appointment already exists on " + date + " for Pacient ID " + pacientId + " and Medic ID " + medicId);
    }
}