package dunzoTest;

import dunzoTest.enums.CoffeeType;
import javafx.util.Pair;


public class CoffeeRequest {
    private Pair<CoffeeType, Integer> requestQuantities;

    public Pair<CoffeeType, Integer> getRequestQuantities() {
        return requestQuantities;
    }

    public void setRequestQuantities(Pair<CoffeeType, Integer> requestQuantities) {
        this.requestQuantities = requestQuantities;
    }
}
