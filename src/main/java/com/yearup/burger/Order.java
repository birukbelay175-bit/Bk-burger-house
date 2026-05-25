package com.yearup.burger;

import java.util.ArrayList;

public class Order {

    private ArrayList<Burger> burgers;
    private ArrayList<Drink> drinks;
    private ArrayList<Side> sides;

    public Order() {

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

        for (Burger burger : burgers) {
            System.out.println(burger);
        }

        for (Drink drink : drinks) {
            System.out.println(drink);
        }

        for (Side side : sides) {
            System.out.println(side);
        }

        System.out.println("-------------------------");
        System.out.printf("Total: $%.2f%n", calculateTotal());
    }
}