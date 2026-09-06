package hospital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientBST patientBST = new PatientBST();
    private static final EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static final TreatmentStack treatmentStack = new TreatmentStack();
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> patientBST.inorderTraversal();
                case 5 -> addToQueue();
                case 6 -> dequeuePatient();
                case 7 -> emergencyQueue.displayQueue();
                case 8 -> completeTreatment();
                case 9 -> treatmentStack.displayStack();
                case 10 -> addVisit();
                case 11 -> removeVisit();
                case 12 -> searchVisit();
                case 13 -> displayVisitHistory();
                case 0 -> {
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=================================================");
        System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("=================================================");
        System.out.println(" -- Patient Records (BST) --");
        System.out.println(" 1. Register New Patient");
        System.out.println(" 2. Search Patient by ID");
        System.out.println(" 3. Delete Patient");
        System.out.println(" 4. Display All Patients (In-Order)");
        System.out.println(" -- Emergency Queue --");
        System.out.println(" 5. Add Patient to Emergency Queue");
        System.out.println(" 6. Dequeue Next Patient for Treatment");
        System.out.println(" 7. Display Emergency Queue");
        System.out.println(" -- Treatment History (Stack) --");
        System.out.println(" 8. Complete Treatment (push record)");
        System.out.println(" 9. Display Treatment History");
        System.out.println(" -- Patient Visit History (Linked List) --");
        System.out.println(" 10. Add Visit to Patient History");
        System.out.println(" 11. Remove Visit from Patient History");
        System.out.println(" 12. Search Visit in Patient History");
        System.out.println(" 13. Display Patient Visit History");
        System.out.println(" 0. Exit");
        System.out.println("=================================================");
    }

    private static void registerPatient() {
        int id = readInt("Enter Patient ID: ");
        if (patientBST.search(id) != null) {
            System.out.println("A patient with ID " + id + " already exists.");
            return;
        }
        String name = readString("Enter Patient Name: ");
        int age = readInt("Enter Age: ");
        String contact = readString("Enter Contact Number: ");
        String condition = readString("Enter Medical Condition: ");

        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
        System.out.println("Patient registered successfully.");
    }

    private static void searchPatient() {
        int id = readInt("Enter Patient ID to search: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("No patient found with ID " + id);
        } else {
            System.out.println("Patient found: " + patient);
        }
    }

    private static void deletePatient() {
        int id = readInt("Enter Patient ID to delete: ");
        boolean deleted = patientBST.delete(id);
        System.out.println(deleted ? "Patient deleted successfully." : "No patient found with ID " + id);
    }

    private static void addToQueue() {
        int id = readInt("Enter Patient ID to add to emergency queue: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("No patient found with ID " + id + ". Please register the patient first.");
            return;
        }
        emergencyQueue.enqueue(patient);
    }

    private static void dequeuePatient() {
        Patient patient = emergencyQueue.dequeue();
        if (patient != null) {
            System.out.println("Now treating: " + patient);
        }
    }

    private static void completeTreatment() {
        int id = readInt("Enter Patient ID whose treatment is complete: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("No patient found with ID " + id);
            return;
        }
        String details = readString("Enter treatment details/notes: ");
        String timestamp = LocalDateTime.now().format(TIME_FORMAT);
        Treatment treatment = new Treatment(id, patient.getName(), details, timestamp);
        treatmentStack.push(treatment);
        System.out.println("Treatment record saved to history.");
    }

    private static void addVisit() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("No patient found with ID " + id);
            return;
        }
        int visitId = readInt("Enter Visit ID: ");
        String date = readString("Enter Visit Date (e.g. 2026-09-05): ");
        String doctor = readString("Enter Doctor Name: ");
        String diagnosis = readString("Enter Diagnosis: ");
        String treatment = readString("Enter Treatment: ");

        Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
        patient.getVisitHistory().add(visit);
        System.out.println("Visit added to patient history.");
    }

    private static void removeVisit() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("No patient found with ID " + id);
            return;
        }
        int visitId = readInt("Enter Visit ID to remove: ");
        boolean removed = patient.getVisitHistory().remove(visitId);
        System.out.println(removed ? "Visit removed." : "No visit found with ID " + visitId);
    }

    private static void searchVisit() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("No patient found with ID " + id);
            return;
        }
        int visitId = readInt("Enter Visit ID to search: ");
        Visit visit = patient.getVisitHistory().search(visitId);
        System.out.println(visit != null ? "Visit found: " + visit : "No visit found with ID " + visitId);
    }

    private static void displayVisitHistory() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("No patient found with ID " + id);
            return;
        }
        patient.getVisitHistory().display();
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}