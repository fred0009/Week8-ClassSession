package com.example.week8;

public class Discount {
    private double discountPercentage;
    Discount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double calculateDiscountedPrice(double price) {
        return price * (100.0 - discountPercentage) / 100.0;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
