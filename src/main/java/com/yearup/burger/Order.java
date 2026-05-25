package com.yearup.burger;

import java.util.ArrayList;

public class Order {

    // Stores all burgers in the order
    private ArrayList<Burger> burgers;

    // Constructor
    public Order() {

        burgers = new ArrayList<>();
    }

    // Adds burger to order
    public void addBurger(Burger burger) {

        burgers.add(burger);
    }

    // Calculates total order price
    public double calculateTotal() {

        double total = 0;

        // Loop through all burgers
        for (Burger burger : burgers) {

            total += burger.calculatePrice();
        }

        return total;
    }

    // Displays order details
    public void displayOrder() {

        System.out.println("\n===== ORDER DETAILS =====");

        for (Burger burger : burgers) {

            System.out.println(burger);
        }

        System.out.println("-------------------------");
        System.out.println("Total: $" + calculateTotal());
    }
}