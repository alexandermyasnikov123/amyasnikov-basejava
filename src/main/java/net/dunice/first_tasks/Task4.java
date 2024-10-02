package net.dunice.first_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    private static final String EXIT_WORD = "exit";

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        List<String> basket = new ArrayList<>();
        while (true) {
            System.out.print("Input new position for addition to basket or \"" + EXIT_WORD + "\" to quit: ");

            var input = scanner.next().trim().toLowerCase();
            var isExit = input.equalsIgnoreCase(EXIT_WORD);

            if (!isExit) {
                basket.add(input);
            }

            System.out.println("There are " + basket.size() + " items in basket");
            basket.forEach(System.out::println);

            if (isExit) return;
        }
    }
}
