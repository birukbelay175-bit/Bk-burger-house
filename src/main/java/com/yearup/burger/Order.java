package com.yearup.burger;

import java.util.ArrayList;

public class Order {

    private ArrayList<Burger> burgers;
    private ArrayList<Drink> drinks;

    public Order() {
        burgers = new ArrayList<>();
        drinks = new ArrayList<>();
    }

    public void addBurger(Burger burger) {
        burgers.add(burger);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public double calculateTotal() {
        double total = 0;

        for (Burger burger : burgers) {
            total += burger.calculatePrice();
        }

        for (Drink drink : drinks) {
            total += drink.calculatePrice();
        }

        return total;
    }

    public void displayOrder() {
        System.out.println("\n===== ORDER DETAILS =====");

        for (Burger burger : burgers) {
            System.out.println(burger);
        }

        for (Drink drink : drinks) {
            System.out.println(drink);
        }

        System.out.println("-------------------------");
        System.out.println("Total: $" + calculateTotal());
    }
}