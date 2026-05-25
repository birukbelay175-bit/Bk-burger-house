package com.yearup.burger;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    private Order order = new Order();
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
                    addBurger();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addSide();
                    break;
                case 4:
                    order.displayOrder();

                    ReceiptFileManager receiptFileManager = new ReceiptFileManager();
                    receiptFileManager.saveReceipt(order);

                    ordering = false;
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
    public void addBurger() {

        // Ask for burger size
        System.out.print("Enter burger size (Small, Medium, Large): ");
        String size = scanner.nextLine();

        // Ask for burger type
        System.out.print("Enter burger type (Beef, Chicken, Veggie): ");
        String type = scanner.nextLine();

        // Ask for double patty option
        System.out.print("Double Patty? (yes/no): ");
        String answer = scanner.nextLine();

        boolean doublePatty = answer.equalsIgnoreCase("yes");

        // Create burger object
        Burger burger = new Burger(size, type, doublePatty);

        // Ask for toppings
        boolean addingToppings = true;

        while (addingToppings) {

            System.out.print("Enter topping (or type done): ");
            String topping = scanner.nextLine();

            if (topping.equalsIgnoreCase("done")) {

                addingToppings = false;

            } else {

                burger.addTopping(topping);
            }
        }

        // Add burger to order
        order.addBurger(burger);

        System.out.println("Burger added successfully!");
    }
    public void addDrink() {

        System.out.print("Enter drink size (Small, Medium, Large): ");
        String size = scanner.nextLine();

        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);

        order.addDrink(drink);

        System.out.println("Drink added successfully!");
    }
    // Adds side to order
    public void addSide() {

        System.out.print("Enter side (Fries, Onion Rings, Salad): ");
        String sideName = scanner.nextLine();

        Side side = new Side(sideName);

        order.addSide(side);

        System.out.println("Side added successfully!");
    }
}
