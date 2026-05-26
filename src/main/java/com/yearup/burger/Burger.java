package com.yearup.burger;

import java.util.ArrayList;

public class Burger {

    private String size;
    private String type;
    private boolean doublePatty;

    // Store topping objects
    private ArrayList<Topping> toppings;

    public Burger(String size, String type, boolean doublePatty) {

        this.size = size;
        this.type = type;
        this.doublePatty = doublePatty;

        toppings = new ArrayList<>();
    }

    // Add topping object
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calculatePrice() {

        double basePrice = 0;

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

        // Extra charge for double patty
        if (doublePatty) {
            basePrice += 2.00;
        }

        // Add topping prices
        for (Topping topping : toppings) {
            basePrice += topping.calculatePrice();
        }

        return basePrice;
    }

    @Override
    public String toString() {

        return size + " " + type + " Burger | Double Patty: "
                + doublePatty + " | Toppings: " + toppings
                + " | Price: $" + calculatePrice();
    }
}