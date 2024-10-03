package net.dunice.coffe_task;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Log {
    private final Coffee coffee;
    private final int cups;
    private final Date date;

    public Log(Coffee coffee, int cups, Date date) {
        this.coffee = coffee;
        this.cups = cups;
        this.date = date;
    }

    @Override
    public String toString() {
        var dateFormat = new SimpleDateFormat("dd MMMM yyyy - HH:mm:ss");
        return String.format("Log %1$s: %2$d cups of %3$s\n", dateFormat.format(date), cups, coffee.getName());
    }
}
