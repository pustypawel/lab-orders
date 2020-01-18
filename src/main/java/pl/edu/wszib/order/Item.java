package pl.edu.wszib.order;

import java.math.BigDecimal;

public class Item {
    private final String name;
    private final BigDecimal price;
    private final Integer stock;

    public Item(String name, BigDecimal price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
