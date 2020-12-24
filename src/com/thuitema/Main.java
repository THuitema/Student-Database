package com.thuitema;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	    // ask user how many students should be created
        System.out.print("How many students would you like to add? ");
        int numStudents = scanner.nextInt();
        Student[] students = new Student[numStudents];

        // create new Student objects and enroll in classes
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            students[i] = new Student();
            students[i].enroll();
            System.out.println();
        }

        runMainMenu(scanner, students);
    }

    public static void runMainMenu(Scanner scanner, Student[] students) {
        // show students created and ask user to select student to view
        while (true) {
            System.out.println("Students Created: ");
            for (int i = 0; i < students.length; i++) {
                System.out.println("[" + (i + 1) + "] " + students[i].getName());
            }
            System.out.print("Select Student to view (type 0 to quit): ");
            int studentSelection = scanner.nextInt() - 1; // Subtracts 1 for it to equal array index

            if (studentSelection == -1) {
                break;
            }

            System.out.println();
            runStudentMenu(scanner, students, studentSelection);
        }
    }

    public static void runStudentMenu(Scanner scanner, Student[] students, int selection) {
        while (true) {
            System.out.println("Options (type 0 to quit): \n[1] View Details\n[2] Change Details\n[3] Pay Balance");
            System.out.println("Enter option");
            int option = scanner.nextInt();

            // quit to main menu
            if (option == 0) {
                break;
            }

            // view student details
            else if (option == 1) {
                System.out.println(students[selection]);
            }

            // change student details
            else if (option == 2) {
                System.out.println("\tSelect detail to change: ");
            }

            // pay tuition balance
            else if (option == 3) {
                students[selection].payBalance();
            }

            else {
                System.out.println("Hm... that didn't compute. Try typing something else");
            }
        }
    }
}
