package dunzoTest.beverages;

import dunzoTest.Constants;
import dunzoTest.enums.CoffeeType;

public class Mocha extends Beverage {

    public Mocha() {
        super(Constants.Mocha.milk, Constants.Mocha.water,
                CoffeeType.MOCHA, Constants.Mocha.sugar, Constants.Mocha.coffeeQuantity);
    }
}
