package net.dunice.coffe_task;

import java.util.Scanner;

public final class InputManager {
    private final CoffeeMachine coffeeMachine = new CoffeeMachine();
    private final Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void greetUser() {
        System.out.println("""
                Welcome to coffee machine CLI.
                Input one of next commands to handle it.
                0 - Exit
                1 - Enable/Disable coffee machine
                2 - Fill coffee beans to machine
                3 - Fill milk to machine
                4 - Fill water to machine
                5 - Check machine was cleaned or not
                6 - Clean machine
                7 - Show machine data (milk, water, beans)
                8 - Make espresso
                9 - Make cappuccino
                """);
    }

    public boolean handleInput(int input) {
        try {
            return handleInputInternal(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean handleInputInternal(int input) {
        switch (input) {
            case 0:
                System.out.println("See your around!");
                return false;
            case 1:
                coffeeMachine.toggleTurnedOn();
                var machineState = coffeeMachine.isTurnedOn() ? "Enabled" : "Disabled";
                System.out.println("The machine state: " + machineState);
                break;
            case 2:
                System.out.print("Input beans amount: ");
                coffeeMachine.fillCoffeeBeans(scanner.nextInt());
                break;
            case 3:
                System.out.print("Input milk amount: ");
                coffeeMachine.fillMilk(scanner.nextInt());
                break;
            case 4:
                System.out.print("Input water amount: ");
                coffeeMachine.fillWater(scanner.nextInt());
                break;
            case 5:
                var shouldBeCleaned = coffeeMachine.shouldBeCleaned();
                var verb = shouldBeCleaned ? "should" : "shouldn't";
                System.out.println("The machine " + verb + " be cleaned");
                break;
            case 6:
                coffeeMachine.clean();
                System.out.println("The machine is clean!");
                break;
            case 7:
                System.out.println(coffeeMachine);
                break;
            case 8:
                coffeeMachine.makeCoffee(Coffee.ESPRESSO);
                System.out.println("Enjoy your delicious espresso!");
                break;
            case 9:
                coffeeMachine.makeCoffee(Coffee.CAPPUCCINO);
                System.out.println("What a nice cappuccino!");
                break;
        }
        return true;
    }
}
