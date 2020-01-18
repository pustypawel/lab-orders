package pl.edu.wszib.order;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String create(Order order) {
        return orderRepository.save(order);
    }

    public boolean exists(String orderId) {
        return orderRepository.exists(orderId);
    }
}
