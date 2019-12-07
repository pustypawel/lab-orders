package pl.edu.wszib;

public class OrderSample {
    public static Order sample() {
        Order order = new Order();
        order.addPosition(PositionSamples.sample());
        return order;
    }
}
