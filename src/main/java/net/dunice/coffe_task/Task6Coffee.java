package net.dunice.coffe_task;

import java.util.Scanner;

public class Task6Coffee {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var manager = new InputManager(scanner);
        do {
            manager.greetUser();
        } while (manager.handleInput(scanner.nextInt()));
    }
}
