package com.example.week8;

public class NestedClassExample {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        OuterClass.StaticInnerClass staticInner = new OuterClass.StaticInnerClass();

    }
}

class OuterClass {
    // Fields
    // Constructor of the object
    // methods
    int a = 10;
    private int b = 20;

    OuterClass() {
        System.out.println("Outer class is created");
    }

    class InnerClass {
        int c = 30;
        private int d = 40;

        InnerClass() {
            // This shows that inner class can access attributes of outer class.
            System.out.println("Inner Class is created");
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
        }
    }

    static class StaticInnerClass {
        int c = 30;
        private int d = 40;

        StaticInnerClass() {
            System.out.println("Static Inner Class is created");
            System.out.println(c);
            System.out.println(d);
        }
    }


}