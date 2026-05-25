package com.yearup.burger;

import java.util.ArrayList;

public class Burger {

    // Burger size (Small, Medium, Large)
    private String size;

    // Burger type (Beef, Chicken, Veggie, etc.)
    private String type;

    // Special option
    private boolean doublePatty;

    // Stores all toppings
    private ArrayList<String> toppings;

    // Constructor
    public Burger(String size, String type, boolean doublePatty) {

        this.size = size;
        this.type = type;
        this.doublePatty = doublePatty;

        // Initialize toppings list
        toppings = new ArrayList<>();
    }

    // Adds toppings to burger
    public void addTopping(String topping) {
        toppings.add(topping);
    }

    // Calculates burger price
    public double calculatePrice() {

        double basePrice = 0;

        // Price based on burger size
        switch (size.toLowerCase()) {

            case "small":
                basePrice = 5.50;
                break;

            case "medium":
                basePrice = 7.00;
                break;

            case "large":
                basePrice = 8.50;
                break;
        }

        // Add extra charge for double patty
        if (doublePatty) {
            basePrice += 2.00;
        }

        // Add topping price
        basePrice += toppings.size() * 0.75;

        return basePrice;
    }

    // Displays burger details
    @Override
    public String toString() {

        return size + " " + type + " Burger | Double Patty: "
                + doublePatty + " | Toppings: " + toppings
                + " | Price: $" + calculatePrice();
    }
}