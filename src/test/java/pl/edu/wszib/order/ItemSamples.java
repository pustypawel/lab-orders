package pl.edu.wszib.order;

import pl.edu.wszib.order.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemSamples {

    public static Item sample() {
        BigDecimal price = new BigDecimal("10.50")
                .setScale(2, RoundingMode.HALF_UP);
        return new Item("Przykładowa pozycja 1", price);
    }

    public static Item sample(String inPrice) {
        BigDecimal price = new BigDecimal(inPrice)
                .setScale(2, RoundingMode.HALF_UP);
        return new Item("Przykładowa pozycja 1", price);
    }
}
