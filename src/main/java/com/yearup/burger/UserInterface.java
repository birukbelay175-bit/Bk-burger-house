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
                    System.out.println("Starting new order...");
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
}
