package ru.dartik;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    private static final int AMOUNT_OF_NUMBERS = 2;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        try {
            System.out.println("Input two numbers");
            List<Integer> numbers = new ArrayList<>();
            for (var i = 0; i < AMOUNT_OF_NUMBERS; ++i) {
                System.out.print("Input a number: ");
                numbers.add(scanner.nextInt());
            }
            var max = numbers.stream().max(Comparator.naturalOrder()).orElseThrow();
            System.out.println("The highest number is " + max);
        } catch (Exception e) {
            System.out.println("Use right formatting, bro");
        }
    }
}
