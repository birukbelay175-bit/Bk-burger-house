package com.yearup.burger;

public class Side {

    private String name;

    public Side(String name) {
        this.name = name;
    }

    public double calculatePrice() {
        switch (name.toLowerCase()) {
            case "fries":
                return 3.00;
            case "onion rings":
                return 3.50;
            case "salad":
                return 4.00;
            default:
                return 2.50;
        }
    }

    @Override
    public String toString() {

        return name.toUpperCase() + " SIDE"
                + String.format("\nPrice: $%.2f", calculatePrice());
    }
}