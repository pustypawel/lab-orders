package pl.edu.wszib.order;

public interface OrderRepository {
    String save(Order order);
    boolean exists(String orderId);
    Order load(String orderId);
}
