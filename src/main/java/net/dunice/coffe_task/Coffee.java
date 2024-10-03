package net.dunice.coffe_task;

import java.util.Objects;
import java.util.Scanner;

public final class Coffee {
    private final int coffee;

    private final int milk;

    private final int water;

    private final String name;

    public Coffee(int coffee, int milk, int water, String name) {
        this.coffee = coffee;
        this.milk = milk;
        this.water = water;
        this.name = name;
    }

    public int getBeans() {
        return coffee;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Coffee %1$s: milk %2$d, water %3$d, beans %4$d", name, milk, water, coffee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Coffee coffee1)) {
            return false;
        }

        return coffee == coffee1.coffee && milk == coffee1.milk &&
               water == coffee1.water && Objects.equals(name, coffee1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffee, milk, water, name);
    }

    public static Coffee inputNew(Scanner scanner) {
        System.out.print("Input coffee name: ");

        var inputName = scanner.next().trim();
        if (inputName.length() < 2) {
            throw new IllegalArgumentException("Name must consists of 2 letters.");
        }

        var name = StringUtils.capitalized(inputName);

        System.out.print("Input amount of milk: ");
        var milk = scanner.nextInt();

        System.out.print("Input amount of water: ");
        var water = scanner.nextInt();

        System.out.print("Input amount of beans: ");
        var beans = scanner.nextInt();

        return new Coffee(beans, milk, water, name);
    }
}
