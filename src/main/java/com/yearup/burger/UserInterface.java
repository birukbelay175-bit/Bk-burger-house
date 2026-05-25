package com.yearup.burger;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    public void display() {

        boolean running = true;

        while (running) {

            System.out.println("\n===== BIRUK'S BURGER HOUSE =====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    displayOrderScreen();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    public void displayOrderScreen() {

        boolean ordering = true;

        while (ordering) {
            System.out.println("\n===== ORDER SCREEN =====");
            System.out.println("1) Add Burger");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Side");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Add Burger selected.");
                    break;
                case 2:
                    System.out.println("Add Drink selected.");
                    break;
                case 3:
                    System.out.println("Add Side selected.");
                    break;
                case 4:
                    System.out.println("Checkout selected.");
                    break;
                case 0:
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
