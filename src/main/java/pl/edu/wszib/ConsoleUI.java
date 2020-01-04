package pl.edu.wszib;

import java.util.Scanner;

public class ConsoleUI {

    public void start() {
        // 1. Utworz zamówienie
        // 2. Wypisz zamówienia
        // 3. Edytuj zamówienie
        // 4. Usuń zamówienie
        // 0. Wyjście
        System.out.println("1. Utworz zamówienie");
        System.out.println("2. Wypisz zamówienia");
        System.out.println("3. Edytuj zamówienie");
        System.out.println("4. Usuń zamówienie");
        System.out.println("5. Wyślij zamówienie na email");
        System.out.println("0. Wyjście");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        UserCommand command = UserCommand.parseUserCommand(line);
    }
}
