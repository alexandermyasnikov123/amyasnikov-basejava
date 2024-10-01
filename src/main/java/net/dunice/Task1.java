package net.dunice;

import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    private static final String MIN_VALUE_NAME = "MIN_VALUE";
    private static final String MAX_VALUE_NAME = "MAX_VALUE";

    public static void main(String[] args) {
        List<Class<? extends Constable>> classes = new ArrayList<>();

        classes.add(Integer.class);
        classes.add(Character.class);
        classes.add(Byte.class);
        classes.add(Float.class);
        classes.add(Double.class);
        classes.add(Long.class);
        classes.add(Short.class);

        classes.forEach((value) -> {
            try {
                System.out.println(findMinMax(value));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println("Don't use dirty hacks bro :)");
            }
        });
    }

    private static ConstableRange findMinMax(Class<? extends Constable> clazz) throws NoSuchFieldException, IllegalAccessException {
        return new ConstableRange(
                (Constable) clazz.getField(MIN_VALUE_NAME).get(null),
                (Constable) clazz.getField(MAX_VALUE_NAME).get(null),
                clazz.getSimpleName()
        );
    }
}

record ConstableRange(Constable min, Constable max, String className) {
}
