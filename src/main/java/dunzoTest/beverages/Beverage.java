package dunzoTest.beverages;

import dunzoTest.enums.CoffeeType;

public class Beverage {
    private int milk;
    private int water;
    private CoffeeType coffeeType;
    private int sugar;
    private int coffeeQuantity;

    public Beverage( int milk, int water, CoffeeType coffeeType, int sugar, int coffeeQuantity){
        this.coffeeType = coffeeType;
        this.milk = milk;
        this.sugar = sugar;
        this.water = water;
        this.coffeeQuantity = coffeeQuantity;
    }


    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }


    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getCoffeeQuantity() {
        return coffeeQuantity;
    }

    public void setCoffeeQuantity(int coffeeQuantity) {
        this.coffeeQuantity = coffeeQuantity;
    }
}
