package com.yearup.burger;

import java.util.Scanner;
public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    private Order order;
    public void display() {

        boolean running = true;
        System.out.println("Welcome to Biruk's Burger House!");
        System.out.println("Build your perfect burger today!\n");
        while (running) {

            System.out.println("\n=================================");
            System.out.println("     BIRUK'S BURGER HOUSE");
            System.out.println("=================================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("=================================");

            System.out.print("Choose an option: ");
            int choice = getMenuChoice();

            switch (choice) {

                case 1:

                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();

                    order = new Order(customerName);

                    displayOrderScreen();
                    break;
                case 0:
                    System.out.println("\nThank you for visiting Biruk's Burger House!");
                    System.out.println("See you again soon!");
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
            System.out.println("\n========== ORDER SCREEN ==========");
            System.out.println("1) Add Burger");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Side");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Choose an option: ");
            int choice = getMenuChoice();

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
                    if (order.isEmpty()) {
                        System.out.println("Cannot checkout. Order is empty.");
                        break;
                    }
                    System.out.println("\nProcessing order...\n");

                    order.displayOrder();

                    ReceiptFileManager receiptFileManager = new ReceiptFileManager();
                    receiptFileManager.saveReceipt(order);

                    System.out.println("\nThank you for choosing Biruk's Burger House!");
                    System.out.println("Your order is complete.");

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

        String size = chooseSize();

        String type = chooseBurgerType();

        System.out.print("Double Patty? (yes/no): ");
        String answer = scanner.nextLine();

        boolean doublePatty = answer.equalsIgnoreCase("yes");

        Burger burger = new Burger(size, type, doublePatty);

        boolean addingToppings = true;

        while (addingToppings) {

            Topping topping = chooseTopping();

            if (topping == null) {

                addingToppings = false;

            } else {

                burger.addTopping(topping);
            }
        }

        order.addBurger(burger);

        System.out.println("Burger added successfully!");
    }
    public String chooseSize() {

        System.out.println("Choose size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        System.out.print("Choose an option: ");
        int choice = getMenuChoice();

        switch (choice) {
            case 1:
                return "small";
            case 2:
                return "medium";
            case 3:
                return "large";
            default:
                return "small";
        }
    }
    public void addDrink() {

        String size = chooseSize();

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
    public int getMenuChoice() {

        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number.");
            scanner.nextLine();
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }
    public String chooseBurgerType() {

        System.out.println("Choose Burger Type:");
        System.out.println("1) Beef");
        System.out.println("2) Chicken");
        System.out.println("3) Veggie");

        System.out.print("Choose an option: ");

        int choice = getMenuChoice();

        switch (choice) {
            case 1:
                return "beef";
            case 2:
                return "chicken";
            case 3:
                return "veggie";
            default:
                return "beef";
        }
    }
    public Topping chooseTopping() {

        System.out.println("\nChoose Topping:");
        System.out.println("1) Lettuce");
        System.out.println("2) Tomato");
        System.out.println("3) Onion");
        System.out.println("4) Bacon");
        System.out.println("5) Avocado");
        System.out.println("0) Done");

        System.out.print("Choose an option: ");

        int choice = getMenuChoice();

        switch (choice) {

            case 1:
                return new Topping("lettuce", false, false);

            case 2:
                return new Topping("tomato", false, false);

            case 3:
                return new Topping("onion", false, false);

            case 4:
                System.out.print("Extra bacon? (yes/no): ");
                String extraAnswer = scanner.nextLine();

                boolean extra = extraAnswer.equalsIgnoreCase("yes");

                return new Topping("bacon", true, extra);

            case 5:

                System.out.print("Extra avocado? (yes/no): ");
                String extraAnswer2 = scanner.nextLine();

                boolean extra2 = extraAnswer2.equalsIgnoreCase("yes");

                return new Topping("avocado", true, extra2);

            default:
                return null;
        }
    }
}

