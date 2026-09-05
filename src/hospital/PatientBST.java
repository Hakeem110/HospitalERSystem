package hospital;

public class PatientBST {

    private class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node root;

    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node node, Patient patient) {
        if (node == null) {
            return new Node(patient);
        }
        if (patient.getPatientId() < node.patient.getPatientId()) {
            node.left = insertRec(node.left, patient);
        } else if (patient.getPatientId() > node.patient.getPatientId()) {
            node.right = insertRec(node.right, patient);
        } else {
            node.patient = patient;
        }
        return node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void inorderTraversal() {
        if (root == null) {
            System.out.println("No patient records found.");
            return;
        }
        System.out.println("--- Patient Records (Ascending Patient ID) ---");
        inorderRec(root);
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println(node.patient);
            inorderRec(node.right);
        }
    }
}