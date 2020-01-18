package pl.edu.wszib.order;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryOrderRepository implements OrderRepository {

    private final Map<String, Order> ordersMap = new HashMap<>();

    @Override
    public String save(Order order) {
        String orderId = UUID.randomUUID().toString();
        ordersMap.put(orderId, order);
        return orderId;
    }

    @Override
    public boolean exists(String orderId) {
        return ordersMap.containsKey(orderId);
    }
}
