package kata.supermarket;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class ItemByUnit implements Item {

    private final Product product;

    ItemByUnit(final Product product) {
        this.product = product;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }
}
