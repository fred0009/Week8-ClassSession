package com.example.week8;

public class BuilderDesignPatternExample {
    public static void main(String[] args) {
        // To create Tea2 object, we make use of the Builder
        Tea2.TeaBuilder teaBuilder = new Tea2.TeaBuilder();
        teaBuilder.setMilk(true).setSugar(true);
        Tea2 tea = teaBuilder.build(); // instantiate Tea2 object
    }
}


class Tea2 {
    private boolean sugar;
    private boolean milk;

    private Tea2(TeaBuilder teaBuilder){
        this.sugar = teaBuilder.sugar;
        this.milk = teaBuilder.milk;
    }

    static class TeaBuilder {
        private boolean sugar;
        private boolean milk;

        TeaBuilder(){}

        public TeaBuilder setSugar ( boolean sugar){
            this.sugar = sugar;
            return this; }

        public TeaBuilder setMilk(boolean milk){
            this .milk = milk;
            return this; }

        public Tea2 build (){
            return new Tea2( this ); }
    }

}
