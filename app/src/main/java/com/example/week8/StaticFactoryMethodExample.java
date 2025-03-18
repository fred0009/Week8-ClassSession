package com.example.week8;

public class StaticFactoryMethodExample {
    public static void main(String[] args) {
        Tea tea = Tea.teh();
        Tea teakosong = Tea.tehkosong();

    }
}

class Tea {
    private boolean sugar;
    private boolean milk;

    Tea( boolean sugar, boolean milk){
        this.sugar = sugar;
        this.milk = milk;
    }
    public static Tea teh(){
        return new Tea( true , true );
    }
    public static Tea tehkosong(){
        return new Tea( false , true );
    }
}

