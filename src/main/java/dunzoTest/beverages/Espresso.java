package dunzoTest.beverages;

import dunzoTest.Constants;
import dunzoTest.enums.CoffeeType;

public class Espresso extends Beverage {
    public Espresso() {
        super(Constants.Espresso.milk, Constants.Espresso.water,
                CoffeeType.ESPRESSO, Constants.Espresso.sugar, Constants.Espresso.coffeeQuantity);
    }
}
