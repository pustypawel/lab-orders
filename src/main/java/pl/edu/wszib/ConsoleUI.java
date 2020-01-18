package pl.edu.wszib;

import pl.edu.wszib.order.Item;
import pl.edu.wszib.order.Order;
import pl.edu.wszib.order.Position;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private static final List<Item> AVAILABLE_ITEMS = Arrays.asList(
            new Item("Pilot", BigDecimal.valueOf(20), 5),
            new Item("Mazak", BigDecimal.valueOf(2), 10),
            new Item("Kabel USB", BigDecimal.valueOf(30), 1),
            new Item("Telefon", BigDecimal.valueOf(500), 3));

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue;
        do {
            showMenu();
            String line = scanner.nextLine();
            UserCommand command = UserCommand.parseUserCommand(line);
            shouldContinue = handleCommand(command, scanner);
        } while (shouldContinue);
    }

    private boolean handleCommand(UserCommand command, Scanner scanner) {
        switch (command) {
            case CREATE:
                createOrder(scanner);
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

    private void createOrder(Scanner scanner) {
        Order order = new Order();
        boolean stillAdding = true;
        do {
            System.out.println("Wybierz przedmiot aby dodać go do zamówienia. Aby zakończyć tworzenie zamówienia naciśnij 0");
            for (int i = 0; i < AVAILABLE_ITEMS.size(); i++) {
                Item item = AVAILABLE_ITEMS.get(i);
                System.out.println((i + 1) + ". " + item.getName() + "(" + item.getPrice() + ")");
            }
            String line = scanner.nextLine();
            try {
                if (line.equals("0")) {
                    stillAdding = false;
                } else {
                    Integer chosenItemIndex = Integer.parseInt(line) - 1;
                    if (chosenItemIndex < 0 || chosenItemIndex >= AVAILABLE_ITEMS.size()) {
                        System.out.println("Wybrałeś przedmiot spoza zakresu");
                    }
                    Item chosenItem = AVAILABLE_ITEMS.get(chosenItemIndex);
                    Integer quantity = askQuantity(scanner, chosenItem);
                    order.addPosition(new Position(quantity, chosenItem));
                }
            } catch (NumberFormatException e) {
                System.out.println("Podana wartość nie jest liczbą");
            }
        } while (stillAdding);

    }

    private Integer askQuantity(Scanner scanner, Item chosenItem) {
        do {
            System.out.println("Podaj ilość: ");
            String quantityLine = scanner.nextLine();
            Integer quantity = Integer.valueOf(quantityLine);
            if (quantity > chosenItem.getStock()) {
                System.out.println("Produkt jest niedostępny w takiej ilości. Maksymalna ilość to " + chosenItem.getStock());
            } else {
                return quantity;
            }
        } while (true);
    }

    private void editOrder() {
        System.out.println("editOrder");
    }

}
