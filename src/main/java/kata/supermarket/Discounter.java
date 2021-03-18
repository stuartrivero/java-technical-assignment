package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class Discounter implements kata.supermarket.discounters.Discounter {

    @Override
    public BigDecimal calculateDiscount(List<Item> items) {
        return BigDecimal.ONE;
    }
}
