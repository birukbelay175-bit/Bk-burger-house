package com.yearup.burger;

public class Topping {

    private String name;
    private boolean premium;
    private boolean extra;

    public Topping(String name, boolean premium, boolean extra) {
        this.name = name;
        this.premium = premium;
        this.extra = extra;
    }

    public double calculatePrice() {
        double price;

        if (premium) {
            price = 1.50;
        } else {
            price = 0.75;
        }

        if (extra) {
            price += 0.50;
        }

        return price;
    }

    @Override
    public String toString() {
        String type = premium ? "Premium" : "Regular";
        String extraText = extra ? " Extra" : "";

        return name + " (" + type + extraText + ") $" + calculatePrice();
    }
}
