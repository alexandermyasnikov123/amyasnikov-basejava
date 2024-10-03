package net.dunice.coffe_task;

import java.util.*;

public final class CoffeeMachine {
    private static final int DEFAULT_MAX_COFFEE = 150;
    private static final int DEFAULT_MAX_MILK = 300;
    private static final int DEFAULT_MAX_WATER = 600;
    private static final int DEFAULT_MAX_USAGE = 3;

    private final int maxCoffeeCapacity;
    private final int maxMilkCapacity;
    private final int maxWaterCapacity;
    private final int maxUsage;

    private int usage;
    private boolean isTurnedOn;
    private int coffeeBeans;
    private int milk;
    private int water;

    private final List<Log> logs = new ArrayList<>();

    public CoffeeMachine(int maxCoffeeCapacity, int maxMilkCapacity, int maxWaterCapacity, int maxUsage) {
        this.maxCoffeeCapacity = maxCoffeeCapacity;
        this.maxMilkCapacity = maxMilkCapacity;
        this.maxWaterCapacity = maxWaterCapacity;
        this.maxUsage = maxUsage;
    }

    public static CoffeeMachine withDefaultSettings() {
        return new CoffeeMachine(DEFAULT_MAX_COFFEE, DEFAULT_MAX_MILK, DEFAULT_MAX_WATER, DEFAULT_MAX_USAGE);
    }

    public void toggleTurnedOn() {
        isTurnedOn = !isTurnedOn;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void checkAmount(int amount, int limit) {
        if (amount <= 0 || amount > limit) {
            throw new IllegalArgumentException("Value must be greater than zero and less than limited amount: " + limit);
        }
    }

    public void fillWater(int water) {
        checkAmount(this.water + water, maxWaterCapacity);
        this.water += water;
    }

    public void fillMilk(int milk) {
        checkAmount(this.milk + milk, maxMilkCapacity);
        this.milk += milk;
    }

    public void fillCoffeeBeans(int coffeeBeans) {
        checkAmount(this.coffeeBeans + coffeeBeans, maxCoffeeCapacity);
        this.coffeeBeans += coffeeBeans;
    }

    private void checkCanMakeCoffee(Coffee coffee, int cups) {
        if (!isTurnedOn()) {
            throw new IllegalStateException("Enable coffee machine before usage");
        }

        if (shouldBeCleaned()) {
            throw new IllegalStateException("Can't make coffee using dirty machine! Clear before use.");
        }

        var canMakeCoffee = (water >= coffee.getWater() * cups) && (milk >= coffee.getMilk() * cups)
                            && (coffeeBeans >= coffee.getBeans() * cups);
        if (!canMakeCoffee) {
            throw new IllegalStateException("Not enough ingredients for coffee " + coffee.getName());
        }
    }

    public void makeCoffee(Coffee coffee, int cups) {
        checkCanMakeCoffee(coffee, cups);

        water -= coffee.getWater() * cups;
        milk -= coffee.getMilk() * cups;
        coffeeBeans -= coffee.getBeans() * cups;
        usage += cups;

        logs.add(new Log(coffee, cups, new Date()));
    }

    public Collection<Log> getLogs() {
        return Collections.unmodifiableList(logs);
    }

    public boolean shouldBeCleaned() {
        return usage >= maxUsage;
    }

    public void clean() {
        if (usage == 0) {
            throw new IllegalStateException("Can't clear an empty machine.");
        }
        usage = 0;
    }

    @Override
    public String toString() {
        return String.format("Machine: milk - %1d, water - %2d, beans - %3d", milk, water, coffeeBeans);
    }
}
