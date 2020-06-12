package dunzoTest.beverages;

import dunzoTest.Constants;
import dunzoTest.enums.CoffeeType;

public class Capuccino  extends Beverage{
    public Capuccino() {
        super(Constants.Capuccino.milk, Constants.Capuccino.water,
                CoffeeType.ESPRESSO, Constants.Capuccino.sugar, Constants.Capuccino.coffeeQuantity);
    }

}
