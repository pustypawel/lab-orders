package pl.edu.wszib;

import pl.edu.wszib.order.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private static final List<Item> availableItems = Arrays.asList(new Item("Pilot", BigDecimal.valueOf(20)),
            new Item("Mazak", BigDecimal.valueOf(2)),
            new Item("Kabel USB", BigDecimal.valueOf(30)),
            new Item("Telefon", BigDecimal.valueOf(500)));

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue;
        do {
            showMenu();
            String line = scanner.nextLine();
            UserCommand command = UserCommand.parseUserCommand(line);
            shouldContinue = handleCommand(command);
        } while (shouldContinue);
    }

    private boolean handleCommand(UserCommand command) {
        switch (command) {
            case CREATE:
                createOrder();
                break;
            case EDIT:
                editOrder();
                break;
            case DELETE:
                deleteOrder();
                break;
            case PRINT_ALL:
                printAll();
                break;
            case EXIT:
                return false;
            case UNKNOWN:
                unknown();
                break;
        }
        return true;
    }

    private void showMenu() {
        System.out.println("1. Utworz zamówienie");
        System.out.println("2. Wypisz zamówienia");
        System.out.println("3. Edytuj zamówienie");
        System.out.println("4. Usuń zamówienie");
        System.out.println("0. Wyjście");
    }

    private void unknown() {
        System.out.println("Unknown");
    }

    private void printAll() {
        System.out.println("printAll");
    }

    private void deleteOrder() {
        System.out.println("deleteOrder");
    }

    private void createOrder() {
        System.out.println("createOrder");
    }

    private void editOrder() {
        System.out.println("editOrder");
    }

}
