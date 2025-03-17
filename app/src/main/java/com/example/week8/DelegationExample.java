package com.example.week8;

public class DelegationExample {
    public static void main(String[] args) {
        Customer c = new Customer();
        Payment creditCard = new CreditCardPayment();
        Payment cash = new CashPayment();
        c.makePayment(creditCard);  // Payment is delegated to Payment object
        c.makePayment(cash);

    }
}

class Customer {
    void makePayment(Payment payment) {
        payment.pay();
    }

    void makeCreditCardPayment() {
        System.out.println("Credit Card is used");
    }

    void makeCashPayment() {
        System.out.println("Cash is used");
    }
}

class ApplePayPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Apple pay is used");
    }
}

class CashPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Cash is used");
    }
}
class CreditCardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Credit card is used");
    }
}

interface Payment {
    void pay();
}