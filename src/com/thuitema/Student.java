package com.thuitema;

import java.util.Scanner;

public class Student {
    Scanner scanner = new Scanner(System.in);

    // Fields
    private String firstName;
    private String lastName;
    private int gradeYear;
    private int studentID;
    private String courses = "";
    private int balance;
    private static final int COURSE_COST = 600;
    private static int id = 0; // Each Student object has a unique ID


    // Constructor for firstName, lastName, and year
    public Student() {
        System.out.print("Enter first name: ");
        this.firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        this.lastName = scanner.nextLine();

        System.out.print("Freshman - 1\nSophomore - 2\nJunior - 3\nSenior - 4\nEnter grade year: ");
        this.gradeYear = scanner.nextInt();
        scanner.nextLine(); // Fixes issue of scanner skipping inputs

        id++;
        createID();
    }

    // Create ID
    private void createID() {
        studentID = gradeYear * 10000 + id;
    }

    // Enroll in Courses
    public void enroll() {
        String course;

        while(true) {
            System.out.println("Enter course (type q to quit): ");
            course = scanner.nextLine();

            if(course.equals("q")) {
                break;
            }

            else {
                courses += "  " + course + "\n";
                balance += COURSE_COST;
            }
        }
    }

    // View Balance
    public void getBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    // Pay Balance
    public void payBalance() {
        getBalance();
        System.out.print("Payment size: $");
        int payment = scanner.nextInt();
        balance -= payment;
        getBalance();
    }

    // toString
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" +
                "Student ID: " + studentID + "\n" +
                "Tuition Balance: $" + balance + "\n" +
                "Courses: " + "\n" + courses;
    }

    // getters
    public String getName() {
        return firstName + " " + lastName;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getCourses() {
        return courses;
    }
}
