package kata.supermarket.discounters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.Product;

public class TwoForOneDiscounter implements Discounter {

    private final Set<Product> products;

    public TwoForOneDiscounter(Set<Product> products) {
        this.products = products;
    }

    @Override
    public BigDecimal calculateDiscount(List<Item> items) {
        var productCount = items.stream()
                .filter(ItemByUnit.class::isInstance)
                .map(it -> ((ItemByUnit) it).getProduct())
                .filter(products::contains)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return productCount.entrySet().stream()
                .map(discount())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private Function<Entry<Product, Long>, BigDecimal> discount() {
        return product -> {
            var pairs = product.getValue() / 2;
            return product.getKey().oneOf().price().multiply(BigDecimal.valueOf(pairs));
        };
    }
}
