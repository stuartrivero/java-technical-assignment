package kata.supermarket.discounters;

import java.math.BigDecimal;
import java.util.List;
import kata.supermarket.Item;

public interface Discounter {

    BigDecimal calculateDiscount(List<Item> items);
}
