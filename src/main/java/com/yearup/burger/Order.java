package com.yearup.burger;

import java.util.ArrayList;
import java.time.LocalDateTime;
public class Order {

    private ArrayList<Burger> burgers;
    private ArrayList<Drink> drinks;
    private ArrayList<Side> sides;
    private String customerName;
    private int orderNumber;

    public Order(String customerName) {
        this.customerName = customerName;
        this.orderNumber = (int) (Math.random() * 9000) + 1000;

        burgers = new ArrayList<>();
        drinks = new ArrayList<>();
        sides = new ArrayList<>();
    }

    public void addBurger(Burger burger) {
        burgers.add(burger);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public double calculateTotal() {

        double total = 0;

        for (Burger burger : burgers) {
            total += burger.calculatePrice();
        }

        for (Drink drink : drinks) {
            total += drink.calculatePrice();
        }

        for (Side side : sides) {
            total += side.calculatePrice();
        }

        return total;
    }

    public void displayOrder() {

        System.out.println("\n===== ORDER DETAILS =====");
        System.out.println("Customer: " + customerName);
        System.out.println("Order #: " + orderNumber);
        System.out.println("-------------------------");

        int burgerCount = 1;

        for (Burger burger : burgers) {

            System.out.println("Burger #" + burgerCount);
            System.out.println(burger);
            System.out.println();

            burgerCount++;
        }

        for (Drink drink : drinks) {
            System.out.println(drink);
        }

        for (Side side : sides) {
            System.out.println(side);
        }

        System.out.println("===============================");
        System.out.printf("ORDER TOTAL: $%.2f%n", calculateTotal());
        System.out.println("===============================");
    }

    // Creates receipt text
    public String getReceiptText() {

        StringBuilder receipt = new StringBuilder();

        receipt.append("=================================\n");
        receipt.append("      BIRUK'S BURGER HOUSE\n");
        receipt.append("=================================\n");
        receipt.append("Date: ").append(LocalDateTime.now()).append("\n");
        receipt.append("Customer: ").append(customerName).append("\n");
        receipt.append("Order #: ").append(orderNumber).append("\n");
        receipt.append("=================================\n\n");

        int burgerCount = 1;

        for (Burger burger : burgers) {

            receipt.append("Burger #").append(burgerCount).append("\n");
            receipt.append(burger).append("\n\n");

            burgerCount++;
        }

        for (Drink drink : drinks) {
            receipt.append(drink).append("\n");
        }

        for (Side side : sides) {
            receipt.append(side).append("\n");
        }

        receipt.append("\n=================================\n");
        receipt.append(String.format("ORDER TOTAL: $%.2f%n", calculateTotal()));
        receipt.append("=================================\n");
        receipt.append("Thank you for your order!\n");

        return receipt.toString();
    }
}