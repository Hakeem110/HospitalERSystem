# Mini Hospital Emergency Management System

A console-based Java application built for **CIT300 - Data Structures and Algorithms**
(Individual Mid Assignment). The system simulates patient registration, emergency
treatment requests, treatment completion, and patient visit history using four
core data structures, each implemented from scratch (no built-in `java.util`
Stack/Queue/LinkedList classes are used for the core logic).

## Data Structures Used

| Requirement | Data Structure | File |
|---|---|---|
| Patient Records | Binary Search Tree (BST), keyed by Patient ID | `PatientBST.java` |
| Emergency Patient Queue | Queue (FIFO), custom linked implementation | `EmergencyQueue.java` |
| Treatment History | Stack (LIFO), custom linked implementation | `TreatmentStack.java` |
| Patient Visit History | Singly Linked List (one per patient) | `VisitLinkedList.java` |

Supporting model classes: `Patient.java`, `Visit.java`, `Treatment.java`.
Application entry point / menu system: `Main.java`.

## Project Structure