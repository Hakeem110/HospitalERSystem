package hospital;

public class Treatment {
    private int patientId;
    private String patientName;
    private String treatmentDetails;
    private String completionTime;

    public Treatment(int patientId, String patientName, String treatmentDetails, String completionTime) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentDetails = treatmentDetails;
        this.completionTime = completionTime;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                " | Name: " + patientName +
                " | Treatment: " + treatmentDetails +
                " | Completed At: " + completionTime;
    }
}