package pl.edu.wszib;

public class OrderSample {
    public static Order sample() {
        Order order = new Order();
        order.addPosition(PositionSamples.sample());
        return order;
    }

    public static Order sampleWithQuantity(int quantity) {
        Order order = new Order();
        order.addPosition(PositionSamples.sampleWithQuantity(quantity));
        return order;
    }
}
