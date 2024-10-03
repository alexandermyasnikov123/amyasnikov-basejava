package net.dunice.coffe_task;

import java.util.Scanner;

public class Task6Coffee {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var manager = new InputManager(scanner);

        while (true) {
            manager.greetUser();
            manager.handleInput();
        }
    }
}
