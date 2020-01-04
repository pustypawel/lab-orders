package pl.edu.wszib;

import java.util.Scanner;

public class ConsoleUI {

    public void start() {
        do {
            System.out.println("1. Utworz zamówienie");
            System.out.println("2. Wypisz zamówienia");
            System.out.println("3. Edytuj zamówienie");
            System.out.println("4. Usuń zamówienie");
            System.out.println("0. Wyjście");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            UserCommand command = UserCommand.parseUserCommand(line);
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
                    return;
                case UNKNOWN:
                    unknown();
                    break;
            }
        } while (true);
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
