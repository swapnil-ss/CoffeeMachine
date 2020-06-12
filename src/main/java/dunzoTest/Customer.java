package dunzoTest;

import dunzoTest.beverages.Beverage;
import dunzoTest.enums.CoffeeType;

import java.util.HashMap;

public class Customer {
    private String name;
    private CoffeeRequest coffeeRequest;
    private CofeeMachine cofeeMachine;

    public Customer(String name, CofeeMachine cofeeMachine){
        this.name = name;
        this.cofeeMachine = cofeeMachine;
    }


    public boolean request(){
        return cofeeMachine.prepareCoffee(coffeeRequest);
    }

    public Beverage collectDrink(CoffeeType coffeeType){
        System.out.println("Collecting coffee ...");
        return cofeeMachine.deliverCoffee(coffeeType);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoffeeRequest getCoffeeRequest() {
        return coffeeRequest;
    }

    public void setCoffeeRequest(CoffeeRequest coffeeRequest) {
        this.coffeeRequest = coffeeRequest;
    }
}
