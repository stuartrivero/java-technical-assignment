package kata.supermarket.discounters;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class TwoForOneDiscounterTest {

    @Test
    void fixedDiscount() {
        BigDecimal discount = new TwoForOneDiscounter().calculateDiscount(Collections.emptyList());
        assertEquals(BigDecimal.ONE, discount);
    }
}