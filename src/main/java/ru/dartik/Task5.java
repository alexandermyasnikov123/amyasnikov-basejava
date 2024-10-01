package ru.dartik;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Input a new password: ");
        var password = scanner.next().trim();
        do {
            System.out.print("Input your password again: ");
        } while (!scanner.next().trim().equals(password));
    }
}
