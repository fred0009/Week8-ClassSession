package com.example.week8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiscountTest {
    @Test
    public void calculateDiscountedPrice_isCorrect() {
        Discount d = new Discount(10.0);

        assertEquals(45.0, d.calculateDiscountedPrice(50.0), 0.001);
    }

    @Test
    public void getDiscountPercentage_isCorrect() {
        Discount d = new Discount(10.0);

        assertEquals(10.0, d.getDiscountPercentage(), 0.001);
    }
}
