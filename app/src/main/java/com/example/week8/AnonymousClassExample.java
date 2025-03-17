package com.example.week8;

public class AnonymousClassExample {
    public static void main(String[] args) {
        // You can create anonymous class by
        // extending a class
        Dragon waterDragon = new Dragon() {
            @Override
            void fly() {
                System.out.println("Splash");
            }
        };
        waterDragon.fly();


        // or, implementing an interface
        Breath fireBreath = new Breath() {
            @Override
            public void breathAction() {
                System.out.println("Faiahhh!");
            }
        };
        fireBreath.breathAction();

    }
}

class Dragon {
    void fly() {
        System.out.println("Whoosh");
    }
}

interface Breath {
    void breathAction();
}