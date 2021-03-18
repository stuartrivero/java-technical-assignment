package kata.supermarket.discounters;

import java.math.BigDecimal;
import java.util.List;
import kata.supermarket.Item;

public class TwoForOneDiscounter implements Discounter {

    @Override
    public BigDecimal calculateDiscount(List<Item> items) {
        return BigDecimal.ONE;
    }
}
