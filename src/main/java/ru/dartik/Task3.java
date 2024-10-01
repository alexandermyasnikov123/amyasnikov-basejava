package ru.dartik;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Task3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        try {
            System.out.println("Input min and max values");
            System.out.print("Input min: ");
            int min = scanner.nextInt();
            System.out.print("Input max: ");
            int max = scanner.nextInt();

            if(max <= min) {
                System.out.println("Values must be in right sequence");
                return;
            }

            IntStream.range(min, max + 1).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Use right number formatting");
        }
    }
}
