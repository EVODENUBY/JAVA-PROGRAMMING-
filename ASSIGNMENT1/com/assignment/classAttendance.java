package com.assignment;

import java.util.Scanner;

public class classAttendance {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // 1. total number of students
        System.out.print("Enter total number of students in the class: ");
        int totalStudents = sc.nextInt();

        // Array to store up to 30 days attendance
        int[] attendance = new int[30];
        int days = 0;

        String choice;

        // 2. Do-while loop to record daily attendance
        do {
            System.out.print("\nEnter number of students Attended on Day " + (days + 1) + ": ");
            attendance[days] = sc.nextInt();
            days++;

            if (days == 30) {
                System.out.println("Maximum 30 days reached.");
                break;
            }

            System.out.print("Do you want to enter attendance for another day? (yes/no): ");
            choice = sc.next();
        } while (choice.equalsIgnoreCase("yes"));

        // 3. Analysis after data entry
        int totalAttendance = 0;
        int lowAttendanceDays = 0;

        for (int i = 0; i < days; i++) {
            totalAttendance += attendance[i];
            if (attendance[i] < (totalStudents / 2.0)) {
                lowAttendanceDays++;
            }
        }

        double averageAttendance = 0;
        if (days > 0) {
            averageAttendance = (double) totalAttendance / days;
        }

        // 4. Print report
        System.out.println("\n== ATTENDANCE REPORT =====");
        System.out.println("Day\tNumber Present");
        for (int i = 0; i < days; i++) {
            System.out.println((i + 1) + "\t" + attendance[i]);
        }

        System.out.println("-----------------------------");
        System.out.println("Total days recorded: " + days);
        System.out.println("Average attendance: " + averageAttendance);
        if (days > 0) {
            double lowPercentage = ((double) lowAttendanceDays / days) * 100;
            System.out.println("Days with low attendance (<50%): " + lowAttendanceDays);
            System.out.println("Percentage of low attendance days: " + lowPercentage + "%");
        }

        sc.close();

	}

}
