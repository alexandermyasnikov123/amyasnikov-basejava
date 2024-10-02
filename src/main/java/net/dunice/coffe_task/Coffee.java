package net.dunice.coffe_task;

public enum Coffee {
    CAPPUCCINO(12, 15, 20), ESPRESSO(16, 12, 24);

    private final int coffee;
    private final int milk;
    private final int water;

    Coffee(int coffee, int milk, int water) {
        this.coffee = coffee;
        this.milk = milk;
        this.water = water;
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
}
