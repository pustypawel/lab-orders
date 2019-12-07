package pl.edu.wszib;

public class Position {
    private final Integer quantity;
    private final Item item;

    public Position(Integer quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Position{" +
                "quantity=" + quantity +
                ", item=" + item +
                '}';
    }
}
