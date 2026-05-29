package com.yearup.burger;

import java.util.Scanner;

public class UserInterface {

    private final String RESET = "\u001B[0m";
    private final String GREEN = "\u001B[32m";
    private final String CYAN = "\u001B[36m";
    private final String YELLOW = "\u001B[33m";
    Scanner scanner = new Scanner(System.in);
    private Order order;

    // Displays the main home screen menu
    public void display() {

        boolean running = true;
        System.out.println("Welcome to Biruk's Burger House!");
        System.out.println("Build your perfect burger today!\n");
        while (running) {

            printHeader("BIRUK'S BURGER HOUSE");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.print("Choose an option: ");
            int choice = getMenuChoice();

            switch (choice) {

                case 1:
                    order = new Order("");
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
            printHeader("ORDER SCREEN");
            System.out.println("1) Add Burger");
            System.out.println("2) Add Signature Burger");
            System.out.println("3) Add Drink");
            System.out.println("4) Add Side");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Choose an option: ");
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    addBurger();
                    break;

                case 2:
                    addSignatureBurger();
                    break;

                case 3:
                    addDrink();
                    break;

                case 4:
                    addSide();
                    break;

                case 5:

                    if (order.isEmpty()) {
                        System.out.println(YELLOW + "Cannot checkout. Order is empty." + RESET);
                        break;
                    }
                    System.out.print("\nEnter customer name: ");
                    String customerName = scanner.nextLine();

                    order.setCustomerName(customerName);

                    boolean paid = reviewOrderBeforePayment();

                    if (paid) {

                        System.out.println("\nProcessing payment...\n");
                        System.out.println("Preparing burgers...");
                        System.out.println("Preparing drinks...");
                        System.out.println("Preparing sides...");
                        System.out.println("Saving receipt...");

                        ReceiptFileManager receiptFileManager = new ReceiptFileManager();
                        receiptFileManager.saveReceipt(order);

                        System.out.println("\nPayment successful!");
                        System.out.println("Thank you for choosing Biruk's Burger House!");
                        System.out.println("Your order is complete.");

                        ordering = false;

                    } else {

                        System.out.println(YELLOW + "\nPayment canceled.");
                        System.out.println("Returning to order screen..." + RESET);
                    }

                    break;
                case 0:

                    String cancelAnswer;

                    while (true) {

                        System.out.print(YELLOW + "\nAre you sure you want to cancel the order? (y/n): " + RESET);
                        cancelAnswer = scanner.nextLine();

                        if (cancelAnswer.equalsIgnoreCase("y") || cancelAnswer.equalsIgnoreCase("n")) {
                            break;
                        }

                        System.out.println(YELLOW + "Please enter y or n only." + RESET);
                    }

                    if (cancelAnswer.equalsIgnoreCase("y")) {

                        System.out.println(YELLOW + "\nOrder canceled successfully.");
                        System.out.println("Returning to home screen..." + RESET);

                        ordering = false;

                    } else {

                        System.out.println(GREEN + "\nReturning to order screen..." + RESET);
                    }

                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Handles burger creation and toppings
    public void addBurger() {

        String size = chooseSize();

        String type = chooseBurgerType();

        String answer;

        while (true) {

            System.out.print("Double Patty? (y/n): ");
            answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")) {
                break;
            }

            System.out.println(YELLOW + "Please enter y or n only." + RESET);
        }

        boolean doublePatty = answer.equalsIgnoreCase("y");
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

        System.out.println(GREEN + "Burger added successfully!" + RESET);
    }

    public String chooseSize() {

        while (true) {
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
                    System.out.println(YELLOW + "Invalid size. Please choose 1, 2, or 3." + RESET);
            }
        }
    }

    public void addDrink() {

        String flavor = chooseDrinkFlavor();

        String size;

        if (flavor.equalsIgnoreCase("water")) {

            size = "medium";

            System.out.println("Water comes in one standard size.");

        } else {

            size = chooseSize();
        }

        Drink drink = new Drink(size, flavor);

        order.addDrink(drink);

        System.out.println(GREEN + "Drink added successfully!" + RESET);
    }

    // Adds side to order
    public void addSide() {

        String sideName = chooseSide();

        Side side = new Side(sideName);

        order.addSide(side);
        System.out.println(GREEN + "Side added successfully!" + RESET);
    }

    // Validates and returns numeric menu input
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

        while (true) {
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
                    System.out.println(YELLOW + "Invalid burger type. Please choose 1, 2, or 3." + RESET);
            }
        }
    }

    public Topping chooseTopping() {

        while (true) {
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
                    System.out.print("Extra bacon? (y/n): ");
                    String extraAnswer = scanner.nextLine();
                    boolean extra = extraAnswer.equalsIgnoreCase("y");
                    return new Topping("bacon", true, extra);
                case 5:
                    System.out.print("Extra avocado? (y/n): ");
                    String extraAnswer2 = scanner.nextLine();
                    boolean extra2 = extraAnswer2.equalsIgnoreCase("y");
                    return new Topping("avocado", true, extra2);
                case 0:
                    return null;
                default:
                    System.out.println(YELLOW + "Invalid topping. Please choose 0-5." + RESET);
            }
        }
    }

    public String chooseDrinkFlavor() {

        while (true) {
            System.out.println("Choose Drink Flavor:");
            System.out.println("1) Coke");
            System.out.println("2) Sprite");
            System.out.println("3) Fanta");
            System.out.println("4) Water");

            System.out.print("Choose an option: ");
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    return "coke";
                case 2:
                    return "sprite";
                case 3:
                    return "fanta";
                case 4:
                    return "water";
                default:
                    System.out.println(YELLOW + "Invalid drink. Please choose 1-4." + RESET);
            }
        }
    }

    public String chooseSide() {

        while (true) {
            System.out.println("Choose Side:");
            System.out.println("1) Fries");
            System.out.println("2) Onion Rings");
            System.out.println("3) Salad");

            System.out.print("Choose an option: ");
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    return "fries";
                case 2:
                    return "onion rings";
                case 3:
                    return "salad";
                default:
                    System.out.println(YELLOW + "Invalid side. Please choose 1, 2, or 3." + RESET);
            }
        }
    }

    public boolean reviewOrderBeforePayment() {

        while (true) {

            System.out.println("\n========== ORDER REVIEW ==========");
            order.displayOrder();

            System.out.println("\n1) Pay and Save Receipt");
            System.out.println(YELLOW + "0) Cancel and Return to Order Screen" + RESET);
            System.out.print("Choose an option: ");

            int choice = getMenuChoice();

            switch (choice) {

                case 1:
                    return true;

                case 0:

                    String cancelPayment;

                    while (true) {

                        System.out.print(YELLOW + "\nAre you sure you want to cancel payment? (y/n): " + RESET);
                        cancelPayment = scanner.nextLine();

                        if (cancelPayment.equalsIgnoreCase("y") || cancelPayment.equalsIgnoreCase("n")) {
                            break;
                        }

                        System.out.println(YELLOW + "Please enter y or n only." + RESET);
                    }

                    if (cancelPayment.equalsIgnoreCase("y")) {
                        return false;
                    }

                    break;

                default:
                    System.out.println(YELLOW + "Invalid option. Please choose 1 or 0." + RESET);
            }
        }
    }

    // Prints styled section headers
    public void printHeader(String title) {
        System.out.println(CYAN + "\n╔═══════════════════════════════╗");
        System.out.println("        " + title);
        System.out.println("╚═══════════════════════════════╝" + RESET);
    }

    public void printDivider() {
        System.out.println("---------------------------------");
    }
    public void addSignatureBurger() {

        System.out.println("Choose Signature Burger:");
        System.out.println("1) Biruk Classic");
        System.out.println("2) Spicy Deluxe");
        System.out.println("3) Veggie Supreme");

        System.out.print("Choose an option: ");

        int choice = getMenuChoice();

        Burger burger;

        switch (choice) {

            case 1:

                burger = new Burger("large", "beef", true);
                burger.addTopping(new Topping("bacon", true, false));
                burger.addTopping(new Topping("lettuce", false, false));
                break;

            case 2:

                burger = new Burger("large", "chicken", true);
                burger.addTopping(new Topping("onion", false, false));
                burger.addTopping(new Topping("bacon", true, false));
                break;

            case 3:

                burger = new Burger("large", "veggie", false);
                burger.addTopping(new Topping("tomato", false, false));
                burger.addTopping(new Topping("lettuce", false, false));
                break;

            default:

                System.out.println("Invalid option.");
                return;
        }

        order.addBurger(burger);

        System.out.println("Signature Burger added successfully!");
    }
}

