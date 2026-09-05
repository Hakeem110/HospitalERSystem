package hospital;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String contactNumber;
    private String medicalCondition;
    private VisitLinkedList visitHistory; // Singly Linked List requirement

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList();
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public VisitLinkedList getVisitHistory() {
        return visitHistory;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                " | Name: " + name +
                " | Age: " + age +
                " | Contact: " + contactNumber +
                " | Condition: " + medicalCondition;
    }
}