package kata.supermarket.discounters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import kata.supermarket.Item;
import kata.supermarket.Product;
import org.junit.jupiter.api.Test;

class TwoForOneDiscounterTest {

    @Test
    void packetsOfBiscuitsAreTwoForOne() {
        var pricePerUnit = new BigDecimal("1.99");
        var biscuits = new Product(pricePerUnit);

        List<Item> items = List.of(biscuits.oneOf(), biscuits.oneOf());

        var discount = new TwoForOneDiscounter(Set.of(biscuits)).calculateDiscount(items);
        assertEquals(pricePerUnit, discount);
    }

    @Test
    void forThreePacketOfBiscuitsTwoAreCharged() {
        var pricePerUnit = new BigDecimal("1.99");
        var biscuits = new Product(pricePerUnit);

        var items = List.of(biscuits.oneOf(), biscuits.oneOf(), biscuits.oneOf());

        var discount = new TwoForOneDiscounter(Set.of(biscuits)).calculateDiscount(items);
        assertEquals(pricePerUnit, discount);
    }

    @Test
    void forTwoPacketOfBiscuitsAndAChocolateBarTheBiscuitsAreDiscounted() {
        var pricePerUnitBiscuits = new BigDecimal("1.99");
        var pricePerUnitChocBar = new BigDecimal("0.95");
        var biscuits = new Product(pricePerUnitBiscuits);
        var chocBar = new Product(pricePerUnitChocBar);

        var items = List.of(biscuits.oneOf(), biscuits.oneOf(), chocBar.oneOf());

        var discount = new TwoForOneDiscounter(Set.of(biscuits)).calculateDiscount(items);
        assertEquals(pricePerUnitBiscuits, discount);
    }

    @Test
    void forTwoPacketOfBiscuitsAndTwoChocolateBarTheBiscuitsAndChocBarAreDiscounted() {
        var pricePerUnitBiscuits = new BigDecimal("1.99");
        var pricePerUnitChocBar = new BigDecimal("0.95");
        var biscuits = new Product(pricePerUnitBiscuits);
        var chocBar = new Product(pricePerUnitChocBar);

        var items = List.of(biscuits.oneOf(), biscuits.oneOf(), chocBar.oneOf(), chocBar.oneOf());

        var discount = new TwoForOneDiscounter(Set.of(biscuits, chocBar)).calculateDiscount(items);
        assertEquals(pricePerUnitBiscuits.add(pricePerUnitChocBar), discount);
    }
}