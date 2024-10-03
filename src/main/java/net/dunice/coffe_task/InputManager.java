package net.dunice.coffe_task;

import net.dunice.coffe_task.commands.DescribedCommand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class InputManager {
    private Scanner scanner;
    private final Coffee espresso = new Coffee(16, 12, 24, "Espresso");
    private final Coffee cappuccino = new Coffee(12, 15, 20, "Cappuccino");
    private final CoffeeMachine coffeeMachine = CoffeeMachine.withDefaultSettings();
    private final List<DescribedCommand> commands = new ArrayList<>();
    private final Set<Coffee> drinks = new HashSet<>();

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
        drinks.add(espresso);
        drinks.add(cappuccino);
        initializeCommands();
    }

    public void greetUser() {
        System.out.println("Welcome to coffee machine CLI.");
        for (var item : commands) {
            System.out.println(item.getDescription());
        }
    }

    public void handleInput() {
        try {
            var index = scanner.nextInt();
            commands.get(index).invoke();
        } catch (InputMismatchException e) {
            System.out.println("You can input only allowed values!");
            scanner = new Scanner(System.in);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Enter only valid commands!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void makeCoffee(Coffee coffee, int cups) {
        coffeeMachine.makeCoffee(coffee, cups);
        System.out.println("Enjoy your delicious " + coffee.getName() + "!");
    }

    private void makeCoffee(Coffee coffee) {
        System.out.print("Input amount of cups: ");
        makeCoffee(coffee, scanner.nextInt());
    }

    private Coffee findCoffee(String name) {
        for (var item : drinks) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    private void addNewProfile() {
        System.out.print("Input coffee name: ");

        var name = scanner.next().trim();
        var coffee = findCoffee(name);

        if (coffee == null) {
            System.out.println("Can't find required coffee.");
            return;
        }

        System.out.print("Input coffee amount: ");
        var amount = scanner.nextInt();

        commands.add(new DescribedCommand(() -> {
            coffeeMachine.makeCoffee(coffee, amount);
            System.out.println("Here are your " + coffee.getName());
        }, String.format("%1d - (Custom profile) Make %2d cups of %3s", commands.size(), amount, coffee.getName())));
    }

    private void initializeCommands() {
        commands.add(new DescribedCommand(() -> {
            System.out.println("See your around!");
            System.exit(0);
        }, "0 - Exit"));

        commands.add(new DescribedCommand(() -> {
            coffeeMachine.toggleTurnedOn();
            var machineState = coffeeMachine.isTurnedOn() ? "Enabled" : "Disabled";
            System.out.println("The machine state: " + machineState);
        }, "1 - Enable/Disable coffee machine"));

        commands.add(new DescribedCommand(() -> {
            System.out.print("Input beans amount: ");
            coffeeMachine.fillCoffeeBeans(scanner.nextInt());
        }, "2 - Fill coffee beans to machine"));

        commands.add(new DescribedCommand(() -> {
            System.out.print("Input milk amount: ");
            coffeeMachine.fillMilk(scanner.nextInt());
        }, "3 - Fill milk to machine"));

        commands.add(new DescribedCommand(() -> {
            System.out.print("Input water amount: ");
            coffeeMachine.fillWater(scanner.nextInt());
        }, "4 - Fill water to machine"));

        commands.add(new DescribedCommand(() -> {
            var shouldBeCleaned = coffeeMachine.shouldBeCleaned();
            var verb = shouldBeCleaned ? "should" : "shouldn't";
            System.out.println("The machine " + verb + " be cleaned");
        }, "5 - Check machine was cleaned or not"));

        commands.add(new DescribedCommand(() -> {
            coffeeMachine.clean();
            System.out.println("The machine is clean!");
        }, "6 - Clean machine"));

        commands.add(new DescribedCommand(() -> System.out.println(coffeeMachine),
                "7 - Show machine data (milk, water, beans)"));

        commands.add(new DescribedCommand(() -> makeCoffee(espresso),
                "8 - Make espresso"));

        commands.add(new DescribedCommand(() -> makeCoffee(cappuccino),
                "9 - Make cappuccino"));

        commands.add(new DescribedCommand(() -> {
            var coffee = Coffee.inputNew(scanner);
            drinks.add(coffee);
            makeCoffee(coffee, 3);
        }, "10 - Make 3 cups of custom drink"));

        commands.add(new DescribedCommand(() -> {
            System.out.println("Logs here: ");
            System.out.println(coffeeMachine.getLogs());
        }, "11 - Output logs"));

        commands.add(new DescribedCommand(() -> {
            System.out.print("Input required coffee name: ");
            var name = scanner.next().trim();
            var coffee = findCoffee(name);
            System.out.println(coffee);
        }, "12 - Find drink by name"));

        commands.add(new DescribedCommand(this::addNewProfile, "13 - Create new profile"));
    }
}
