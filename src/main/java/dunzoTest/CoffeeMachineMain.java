package dunzoTest;

import dunzoTest.enums.CoffeeType;
import javafx.util.Pair;

public class CoffeeMachineMain {
    public static void main(String[] args) {

        CofeeMachine cofeeMachine = CofeeMachine.getInstance();

        System.out.println("-----------Test Case 1 ------------------\n");
        happyCase(cofeeMachine);

        System.out.println("-----------Test Case 2 ------------------\n");
        happyCase2(cofeeMachine);

        System.out.println("-----------Test Case 3 ------------------\n");
        ingredientsDryOut(cofeeMachine);

        System.out.println("-----------Test Case 4 ------------------\n");
        tapsDryOut(cofeeMachine);

        System.out.println("-----------Test Case 5 ------------------\n");
        nullPointerCheck(cofeeMachine);

    }

    public static void happyCase(CofeeMachine cofeeMachine){
        cofeeMachine.totalTaps = 3;
        cofeeMachine.start();
        Customer a = new Customer("Swapnil", cofeeMachine);
        CoffeeRequest coffeeRequest = new CoffeeRequest();
        coffeeRequest.setRequestQuantities(new Pair<CoffeeType, Integer>(CoffeeType.ESPRESSO,1));
        a.setCoffeeRequest(coffeeRequest);

        a.request();
        a.collectDrink(CoffeeType.ESPRESSO);

        if(cofeeMachine.getBeverages().size() == 0 && cofeeMachine.getTotalTapsAvailable() == cofeeMachine.totalTaps){
            System.out.print(" Happy Case Verified\n ");
        }

    }

    public static void happyCase2(CofeeMachine cofeeMachine){
        cofeeMachine.totalTaps = 5;
        cofeeMachine.start();
        Customer a = new Customer("Swapnil", cofeeMachine);
        CoffeeRequest coffeeRequest = new CoffeeRequest();
        coffeeRequest.setRequestQuantities(new Pair<CoffeeType, Integer>(CoffeeType.ESPRESSO,1));
        a.setCoffeeRequest(coffeeRequest);

        a.request();
        a.request();
        a.collectDrink(CoffeeType.ESPRESSO);

        if(cofeeMachine.getBeverages().size() == 1 && cofeeMachine.getTotalTapsAvailable() == 4){
            System.out.print(" Happy Case Verified\n");
        }

    }

    public static void ingredientsDryOut(CofeeMachine cofeeMachine){
        cofeeMachine.totalTaps = 5;
        cofeeMachine.start();
        Customer a = new Customer("Swapnil", cofeeMachine);
        CoffeeRequest coffeeRequest = new CoffeeRequest();
        coffeeRequest.setRequestQuantities(new Pair<CoffeeType, Integer>(CoffeeType.ESPRESSO,1));
        a.setCoffeeRequest(coffeeRequest);

        a.request();
        a.request();
        a.request();
        a.request();
        a.request();
        a.collectDrink(CoffeeType.ESPRESSO);

        // Ingredients dry out
        a.request();
        System.out.print(" Ingredients dry out\n");

    }

    public static void tapsDryOut(CofeeMachine cofeeMachine){
        cofeeMachine.totalTaps = 3;
        cofeeMachine.start();
        Customer a = new Customer("Swapnil", cofeeMachine);
        CoffeeRequest coffeeRequest = new CoffeeRequest();
        coffeeRequest.setRequestQuantities(new Pair<CoffeeType, Integer>(CoffeeType.ESPRESSO,1));
        a.setCoffeeRequest(coffeeRequest);
        a.request();

        coffeeRequest.setRequestQuantities(new Pair<CoffeeType, Integer>(CoffeeType.MOCHA,1));
        a.setCoffeeRequest(coffeeRequest);
        a.request();

        coffeeRequest.setRequestQuantities(new Pair<CoffeeType, Integer>(CoffeeType.MOCHA,1));
        a.setCoffeeRequest(coffeeRequest);
        a.request();

        coffeeRequest.setRequestQuantities(new Pair<CoffeeType, Integer>(CoffeeType.MOCHA,1));
        a.setCoffeeRequest(coffeeRequest);
        a.request();

        coffeeRequest.setRequestQuantities(new Pair<CoffeeType, Integer>(CoffeeType.ESPRESSO,1));
        a.request();
        a.request();
    }

    public static void nullPointerCheck(CofeeMachine cofeeMachine){
        cofeeMachine.totalTaps = 3;
        cofeeMachine.start();
        Customer a = new Customer("Swapnil", cofeeMachine);
        CoffeeRequest coffeeRequest = new CoffeeRequest();
        coffeeRequest.setRequestQuantities(new Pair<CoffeeType, Integer>(CoffeeType.ESPRESSO,1));
        a.setCoffeeRequest(coffeeRequest);

        a.request();

        if(a.collectDrink(CoffeeType.MOCHA) ==null){
            System.out.print(" Wrong input\n ");
        }

    }

}
