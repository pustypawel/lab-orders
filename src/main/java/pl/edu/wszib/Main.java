package pl.edu.wszib;

import pl.edu.wszib.order.InMemoryOrderRepository;
import pl.edu.wszib.order.OrderService;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService(new InMemoryOrderRepository());
        ConsoleUI consoleUI = new ConsoleUI(orderService);
        consoleUI.start();
    }
}
