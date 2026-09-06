package hospital;

/**
 * Stack (LIFO) that stores completed treatment records.
 * Custom linked implementation.
 */
public class TreatmentStack {

    private class Node {
        Treatment treatment;
        Node next;

        Node(Treatment treatment) {
            this.treatment = treatment;
        }
    }

    private Node top;
    private int size;

    public void push(Treatment treatment) {
        Node newNode = new Node(treatment);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Treatment pop() {
        if (isEmpty()) {
            System.out.println("Treatment history is empty. Nothing to pop.");
            return null;
        }
        Treatment treatment = top.treatment;
        top = top.next;
        size--;
        return treatment;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("No treatment history recorded yet.");
            return;
        }
        System.out.println("--- Treatment History (most recent first) ---");
        Node current = top;
        while (current != null) {
            System.out.println(current.treatment);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}