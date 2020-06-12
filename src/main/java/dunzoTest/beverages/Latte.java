package dunzoTest.beverages;

import dunzoTest.Constants;
import dunzoTest.enums.CoffeeType;

public class Latte extends Beverage {
    public Latte() {
        super(Constants.Latte.milk, Constants.Latte.water,
                CoffeeType.LATTE, Constants.Latte.sugar, Constants.Latte.coffeeQuantity);
    }
}
