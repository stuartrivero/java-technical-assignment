package kata.supermarket.discounters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kata.supermarket.Item;
import kata.supermarket.Product;
import org.junit.jupiter.api.Test;

class TwoForOneDiscounterTest {

    @Test
    void packetsOfBiscuitsAreTwoForOne() {
        BigDecimal pricePerUnit = new BigDecimal("1.99");
        Product biscuits = new Product(pricePerUnit);

        List<Item> items = new ArrayList<>();
        items.add(biscuits.oneOf());
        items.add(biscuits.oneOf());

        BigDecimal discount = new TwoForOneDiscounter(Set.of(biscuits)).calculateDiscount(items);
        assertEquals(pricePerUnit, discount);
    }

    @Test
    void forThreePacketOfBiscuitsTwoAreCharged() {
        BigDecimal pricePerUnit = new BigDecimal("1.99");
        Product biscuits = new Product(pricePerUnit);

        List<Item> items = new ArrayList<>();
        items.add(biscuits.oneOf());
        items.add(biscuits.oneOf());
        items.add(biscuits.oneOf());

        BigDecimal discount = new TwoForOneDiscounter(Set.of(biscuits)).calculateDiscount(items);
        assertEquals(pricePerUnit, discount);
    }

    @Test
    void forTwoPacketOfBiscuitsAndAChocolateBarTheBiscuitsAreDiscounted() {
        BigDecimal pricePerUnitBiscuits = new BigDecimal("1.99");
        BigDecimal pricePerUnitChocBar = new BigDecimal("0.95");
        Product biscuits = new Product(pricePerUnitBiscuits);
        Product chocBar = new Product(pricePerUnitChocBar);

        List<Item> items = new ArrayList<>();
        items.add(biscuits.oneOf());
        items.add(biscuits.oneOf());
        items.add(chocBar.oneOf());

        BigDecimal discount = new TwoForOneDiscounter(Set.of(biscuits)).calculateDiscount(items);
        assertEquals(pricePerUnitBiscuits, discount);
    }

    @Test
    void forTwoPacketOfBiscuitsAndTwoChocolateBarTheBiscuitsAndChocBarAreDiscounted() {
        BigDecimal pricePerUnitBiscuits = new BigDecimal("1.99");
        BigDecimal pricePerUnitChocBar = new BigDecimal("0.95");
        Product biscuits = new Product(pricePerUnitBiscuits);
        Product chocBar = new Product(pricePerUnitChocBar);

        List<Item> items = new ArrayList<>();
        items.add(biscuits.oneOf());
        items.add(biscuits.oneOf());
        items.add(chocBar.oneOf());
        items.add(chocBar.oneOf());

        BigDecimal discount = new TwoForOneDiscounter(Set.of(biscuits, chocBar)).calculateDiscount(items);
        assertEquals(pricePerUnitBiscuits.add(pricePerUnitChocBar), discount);
    }
}