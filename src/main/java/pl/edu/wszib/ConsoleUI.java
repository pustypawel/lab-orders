package pl.edu.wszib;

import java.util.Scanner;

public class ConsoleUI {

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
