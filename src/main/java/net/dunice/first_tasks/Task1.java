package net.dunice.first_tasks;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Min char is " + Character.MIN_VALUE);
        System.out.println("Max char is " + Character.MAX_VALUE);

        System.out.println("Min byte is " + Byte.MIN_VALUE);
        System.out.println("Max byte is " + Byte.MAX_VALUE);

        System.out.println("Min boolean is " + Boolean.FALSE);
        System.out.println("Max boolean is " + Boolean.TRUE);

        System.out.println("Min short is " + Short.MIN_VALUE);
        System.out.println("Max short is " + Short.MAX_VALUE);

        System.out.println("Min int is " + Integer.MIN_VALUE);
        System.out.println("Max int is " + Integer.MAX_VALUE);

        System.out.println("Min long is " + Long.MIN_VALUE);
        System.out.println("Max long is " + Long.MAX_VALUE);

        System.out.println("Min float is " + Float.MIN_VALUE);
        System.out.println("Max float is " + Float.MAX_VALUE);

        System.out.println("Min double is " + Double.MIN_VALUE);
        System.out.println("Max double is " + Double.MAX_VALUE);

        var someText = "Some text";
        var numbers = new int[]{1, 2, 3, 4, 5};
        System.out.println("String variable is " + someText);
        System.out.println("Array variable is " + Arrays.toString(numbers));
    }
}
