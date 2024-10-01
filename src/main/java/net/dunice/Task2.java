package net.dunice;

import java.util.*;

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
            var max = findMax(numbers);
            System.out.println("The highest number is " + max);
        } catch (Exception e) {
            System.out.println("Use right formatting, bro");
        }
    }

    public static int findMax(Collection<Integer> collection) {
        int max = Integer.MIN_VALUE;
        for (var item : collection) {
            if(item > max) max = item;
        }
        return max;
    }
}
