package pl.edu.wszib.order;

public class Position {
    private Integer quantity;
    private final Item item;

    public Position(Integer quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public void increaseQuantity() {
        quantity = quantity + 1;
    }

    public void decreaseQuantity() {
        if (quantity > 1) {
            quantity = quantity - 1;
        } else {
            throw new IllegalStateException("quantity has to be greater than 1. quantity = " + quantity);
        }
    }

    public void setQuantity(Integer newQuantity) {
        if (newQuantity > 0) {
            quantity = newQuantity;
        } else {
            throw new IllegalArgumentException("quantity has to be greater than 0. quantity = " + quantity);
        }
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
