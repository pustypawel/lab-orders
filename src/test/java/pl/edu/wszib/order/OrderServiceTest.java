package pl.edu.wszib.order;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceTest {

    private OrderService orderService;

    @Before
    public void setup() {
        OrderRepository orderRepository = new InMemoryOrderRepository();
        orderService = new OrderService(orderRepository);
    }

    @Test
    public void shouldBeAbleToCreateOrder() {
        // given:
        Order order = OrderSample.sample();

        // when:
        String orderId = orderService.create(order);

        // then:
        assertNotNull(orderId);
        boolean exists = orderService.exists(orderId);
        assertTrue(exists);
    }

}