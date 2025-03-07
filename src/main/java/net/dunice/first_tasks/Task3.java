package net.dunice.first_tasks;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        try {
            System.out.println("Input min and max values");
            System.out.print("Input min: ");
            int min = scanner.nextInt();
            System.out.print("Input max: ");
            int max = scanner.nextInt();

            if (max <= min) {
                System.out.println("Values must be in right sequence");
                return;
            }

            for (int i = min; i <= max; ++i) {
                if(isPrime(i)) {
                    System.out.println(i);
                }
            }
        } catch (Exception e) {
            System.out.println("Use right number formatting");
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
