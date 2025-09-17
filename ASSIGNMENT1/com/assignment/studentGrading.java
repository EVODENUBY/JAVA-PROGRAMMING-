package com.assignment;

import java.util.Scanner;

public class studentGrading {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        int totalStudents = 0;
	        int passes = 0;
	        int fails = 0;

	        // 2. Use while loop with sentinel value (-1)
	        System.out.println("Enter student marks (0–100), or -1 to stop:");

	        int marks = sc.nextInt();

	        while (marks != -1) {
	            if (marks >= 80 && marks <= 100) {
	                System.out.println("Grade: A");
	            } else if (marks >= 70) {
	                System.out.println("Grade: B");
	            } else if (marks >= 60) {
	                System.out.println("Grade: C");
	            } else if (marks >= 50) {
	                System.out.println("Grade: D");
	            } else if (marks >= 0) {
	                System.out.println("Grade: F");
	            } else {
	                System.out.println("Invalid marks! Please enter marks between 0–100, or -1 to stop.");
	                // Don’t count invalid input as a student
	                marks = sc.nextInt();
	                continue;
	            }

	            // 4. Count student results
	            totalStudents++;
	            if (marks >= 50) {
	                passes++;
	            } else {
	                fails++;
	            }

	            // Ask Again until he/she stops 
	            System.out.println("Continue adding other student marks:  ");
	            marks = sc.nextInt();
	        }

	        // 5. Summary report
	        System.out.println("\n===== SUMMARY REPORT =====");
	        System.out.println("Total students: " + totalStudents);
	        System.out.println("Passed: " + passes);
	        System.out.println("Failed: " + fails);

	        if (totalStudents > 0) {
	            double passRate = ((double) passes / totalStudents) * 100;
	            System.out.println("Class pass rate: " + passRate + "%");
	        } else {
	            System.out.println("No student data entered.");
	        }

	        sc.close();

	}

}
