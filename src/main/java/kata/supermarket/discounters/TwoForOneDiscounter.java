package kata.supermarket.discounters;

import java.math.BigDecimal;
import java.util.List;
import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.Product;

public class TwoForOneDiscounter implements Discounter {

    private final Product product;

    public TwoForOneDiscounter(Product product) {
        this.product = product;
    }

    @Override
    public BigDecimal calculateDiscount(List<Item> items) {
        long number = items.stream()
                .filter(ItemByUnit.class::isInstance)
                .filter(it -> ((ItemByUnit) it).getProduct().equals(product)).count();
        long pairs = number / 2;
        return product.oneOf().price().multiply(BigDecimal.valueOf(pairs));
    }
}
