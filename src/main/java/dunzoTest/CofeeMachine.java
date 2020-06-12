package dunzoTest;

import dunzoTest.beverages.Beverage;
import dunzoTest.beverages.Espresso;
import dunzoTest.beverages.Mocha;
import dunzoTest.enums.CoffeeType;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CofeeMachine {
    private List<Beverage> beverages;
    public int totalTaps ;
    private int totalTapsAvailable;
    private int totalMilk;
    private int totalWater;
    private int totalSugar;
    private HashMap<CoffeeType, Integer> coffeePowderQuantity;

    private Admin admin;

    private static CofeeMachine cofeeMachine_Instance = null;
    private CofeeMachine( ) {

    }

    public static CofeeMachine getInstance(){
        if(cofeeMachine_Instance == null){
            cofeeMachine_Instance = new CofeeMachine();
            return cofeeMachine_Instance;
        }
        return cofeeMachine_Instance;
    }

    public void notifyAdmin(){
    /**
    * Call to update Ingredients once
    * */
        //admin.updateIngredients();
    }

    public void start(){
        this.totalTapsAvailable = totalTaps;
        this.totalMilk = 100;
        this.totalMilk = 100;
        this.totalSugar = 100;
        this.totalWater = 100;
        HashMap<CoffeeType, Integer> coffees = new HashMap<CoffeeType, Integer>();
        coffees.put(CoffeeType.CAPUCCINO, 100);
        coffees.put(CoffeeType.MOCHA, 100);
        coffees.put(CoffeeType.LATTE, 100);
        coffees.put(CoffeeType.ESPRESSO, 100);
        this.coffeePowderQuantity = coffees;
        this.beverages = new ArrayList<Beverage>();
    }


    synchronized public boolean prepareCoffee(CoffeeRequest coffeeRequest){

        System.out.println("Preparing Coffee " + (totalTaps-this.totalTapsAvailable+1));
        if(checkIngredients(coffeeRequest)){
            if(coffeeRequest.getRequestQuantities().getKey().equals(CoffeeType.ESPRESSO)){
                Espresso espresso = new Espresso();
                this.totalSugar -= Constants.Espresso.sugar;
                this.totalMilk -= Constants.Espresso.milk;
                this.totalWater -= Constants.Espresso.water;
                this.coffeePowderQuantity.put(CoffeeType.ESPRESSO,coffeePowderQuantity.get(CoffeeType.ESPRESSO)-
                        Constants.Espresso.coffeeQuantity);
                beverages.add(espresso);
            }
            if(coffeeRequest.getRequestQuantities().getKey().equals(CoffeeType.MOCHA)){
                Mocha mocha = new Mocha();
                this.totalSugar -= Constants.Mocha.sugar;
                this.totalMilk -= Constants.Mocha.milk;
                this.totalWater -= Constants.Mocha.water;
                this.coffeePowderQuantity.put(CoffeeType.MOCHA,coffeePowderQuantity.get(CoffeeType.MOCHA)-
                        Constants.Mocha.coffeeQuantity);
                beverages.add(mocha);
            }
        }
        return true;
    }

    synchronized public Beverage deliverCoffee(CoffeeType coffeeType){

        Beverage coffee = null;
        if(!coffeeType.equals(CoffeeType.ESPRESSO)){
            System.out.println("Mismatch in Request Response");
            return coffee;
        }
        for(Beverage beverage: beverages){
            if(beverage.getCoffeeType().equals(CoffeeType.ESPRESSO)){
                coffee = (Espresso) beverage;
                beverages.remove(coffee);
                break;
            }

            if(beverage.getCoffeeType().equals(CoffeeType.MOCHA)){
                coffee = (Mocha) beverage;
                beverages.remove(coffee);
                break;
            }
            /**
             * Extrapolate for all the other CoffeeType
             * */
        }

        this.totalTapsAvailable++;
        System.out.println(this.totalTapsAvailable);
        System.out.print(coffee.getCoffeeType().name() + "  Collected.. ");
        return coffee;
    }

    public boolean checkIngredients(CoffeeRequest coffeeRequest){

        Pair<CoffeeType, Integer> coffeeTypeQuantityMap = coffeeRequest.getRequestQuantities();
        switch(coffeeTypeQuantityMap.getKey()){
            case MOCHA:
                if(Constants.Mocha.coffeeQuantity > this.coffeePowderQuantity.get(CoffeeType.MOCHA)){
                    System.out.println("No Coffee Powder Available");
                    notifyAdmin();
                    return false;
                }
                if(Constants.Mocha.water > this.totalWater){
                    System.out.println("No water Available");
                    notifyAdmin();
                    return false;
                }
                if(Constants.Mocha.milk > this.totalMilk){
                    System.out.println("No Milk available");
                    notifyAdmin();
                    return false;
                }
                if(Constants.Mocha.sugar > this.totalSugar){
                    System.out.println("No sugar available");
                    return false;
                }
            case LATTE:
                if(Constants.Latte.coffeeQuantity > this.coffeePowderQuantity.get(CoffeeType.LATTE)){
                    return false;
                }
                if(Constants.Latte.water > this.totalWater){
                    return false;
                }
                if(Constants.Latte.milk > this.totalMilk){
                    return false;
                }
                if(Constants.Latte.sugar > this.totalSugar){
                    return false;
                }
            case ESPRESSO:
                if(Constants.Espresso.coffeeQuantity > this.coffeePowderQuantity.get(CoffeeType.ESPRESSO)){
                    System.out.println("No Coffee Powder Available");

                    return false;
                }
                if(Constants.Espresso.water > this.totalWater){
                    System.out.println("No water Available");

                    return false;
                }
                if(Constants.Espresso.milk > this.totalMilk){
                    System.out.println("No Milk available");
                    return false;
                }
                if(Constants.Espresso.sugar > this.totalSugar){
                    System.out.println("No sugar available");

                    return false;
                }
            case CAPUCCINO:
                if(Constants.Capuccino.coffeeQuantity > this.coffeePowderQuantity.get(CoffeeType.CAPUCCINO)){
                    return false;
                }
                if(Constants.Capuccino.water > this.totalWater){
                    return false;
                }
                if(Constants.Capuccino.milk > this.totalMilk){
                    return false;
                }
                if(Constants.Capuccino.sugar > this.totalSugar){
                    return false;
                }
        }
        this.totalTapsAvailable--;
        if(this.totalTapsAvailable < 0){
            System.out.println("No Taps Available");
            return false;
        }

        return true;

    }

    synchronized public List<Beverage> getBeverages() {
        return beverages;
    }

    synchronized public void setBeverages(List<Beverage> beverages) {
        this.beverages = beverages;
    }


    synchronized public int getTotalTapsAvailable() {
        return totalTapsAvailable;
    }

    synchronized public void setTotalTapsAvailable(int totalTapsAvailable) {
        this.totalTapsAvailable = totalTapsAvailable;
    }

    synchronized public int getTotalMilk() {
        return totalMilk;
    }

    synchronized public void setTotalMilk(int totalMilk) {
        this.totalMilk = totalMilk;
    }

    synchronized public int getTotalWater() {
        return totalWater;
    }

    synchronized public void setTotalWater(int totalWater) {
        this.totalWater = totalWater;
    }

    synchronized public int getTotalSugar() {
        return totalSugar;
    }

    synchronized public void setTotalSugar(int totalSugar) {
        this.totalSugar = totalSugar;
    }

    synchronized public HashMap<CoffeeType, Integer> getCoffeePowderQuantity() {
        return coffeePowderQuantity;
    }

    synchronized public void setCoffeePowderQuantity(HashMap<CoffeeType, Integer> coffeePowderQuantity) {
        this.coffeePowderQuantity = coffeePowderQuantity;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
