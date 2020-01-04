package pl.edu.wszib;

import pl.edu.wszib.order.Order;

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
