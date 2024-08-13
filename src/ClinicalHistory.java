public class ClinicalHistory {
    private Treatment treatment;
    private Apointment apointment;
    private int idCh;

    public ClinicalHistory(Treatment treatment, Apointment apointment, int idCh) {
        this.treatment = treatment;
        this.apointment = apointment;
        this.idCh = idCh;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Apointment getApointment() {
        return apointment;
    }

    public void setApointment(Apointment apointment) {
        this.apointment = apointment;
    }

    public int getIdCh() {
        return idCh;
    }

    public void setIdCh(int idCh) {
        this.idCh = idCh;
    }

    @Override
    public String toString() {
        return "ClinicalHistory{" +
                "treatment=" + treatment +
                ", apointment=" + apointment +
                ", idCh=" + idCh +
                '}';
    }
}
