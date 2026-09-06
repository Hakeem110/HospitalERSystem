package hospital;

/**
 * Queue (FIFO) that manages patients waiting in the emergency unit.
 * Custom linked implementation with front/rear pointers.
 */
public class EmergencyQueue {

    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient " + patient.getName() + " (ID: " + patient.getPatientId()
                + ") added to the emergency waiting queue.");
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty. No patients waiting.");
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return patient;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting in the emergency queue.");
            return;
        }
        System.out.println("--- Emergency Waiting Queue (front -> rear) ---");
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient);
            current = current.next;
            position++;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}