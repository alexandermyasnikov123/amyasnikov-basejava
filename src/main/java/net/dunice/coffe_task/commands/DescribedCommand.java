package net.dunice.coffe_task.commands;

public class DescribedCommand implements Command{
    private final Command command;
    private final String description;

    public DescribedCommand(Command command, String description) {
        this.command = command;
        this.description = description;
    }

    @Override
    public void invoke() {
        command.invoke();
    }

    public String getDescription() {
        return description;
    }
}
