package net.dunice.coffe_task;

public final class StringUtils {
    private StringUtils() {}

    public static String capitalized(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
