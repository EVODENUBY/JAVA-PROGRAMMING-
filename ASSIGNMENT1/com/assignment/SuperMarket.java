package com.assignment;

import java.util.Scanner;

public class SuperMarket {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // 1. Ask Cashier for number of items
        System.out.print("how many different items the customer bought: ");
        int numItems = sc.nextInt();
        sc.nextLine(); 

        // Arrays to store item details
        String[] itemNames = new String[numItems];
        double[] prices = new double[numItems];
        int[] quantities = new int[numItems];
        double[] subtotals = new double[numItems];

        double totalBill = 0;
        
        for (int i = 0; i < numItems; i++) {
            System.out.println("\nEnter details for item " + (i + 1));

            System.out.print("Item name:  ");
            itemNames[i] = sc.nextLine();

            System.out.print("Price per unit: ");
            prices[i] = sc.nextDouble();

            System.out.print("Quantity: ");
            quantities[i] = sc.nextInt();
            sc.nextLine();

            //  Calculate subTotal
            subtotals[i] = prices[i] * quantities[i];
            totalBill += subtotals[i];
        }

        // 5. Checking  discount for Customers
        double discount = 0;
        if (totalBill > 50000) {
            discount = totalBill * 0.05;
        }
        double finalAmount = totalBill - discount;

        // 6. Print receipt 
        System.out.println("\n===== SUPERMARKET RECEIPT =====");
        System.out.println("Item\t\tQuantity\t\tPrice\t\tSubtotal");

        for (int i = 0; i < numItems; i++) {
            System.out.println(itemNames[i] + "\t\t" + quantities[i]+"kgs" + "\t\t" + prices[i]+"Rwf" + "\t\t" + subtotals[i]+"Rwf");
        }

        System.out.println("-------------------------------");
        System.out.println(" Total Bill: " + totalBill +"Rwf");
        System.out.println("Discount: " + discount+"Rwf");
        System.out.println("Final Amount Payable: " + finalAmount +"Rwf");
         sc.close();
	 
	 

	}

}
