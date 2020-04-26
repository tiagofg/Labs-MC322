package br.unicamp.ic.mc322.lab05.reminders.events;

import br.unicamp.ic.mc322.lab05.reminders.Reminder;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Reminder {

    private ZonedDateTime date;

    public Event(String description, ZonedDateTime date) {
        super(description);
        this.date = date;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Evento: " +
                getDescription() + ", " +
                "Data: " + date.format(formatter);
    }

    public boolean isInThisDay(ZonedDateTime dateTime) {
        return date.equals(dateTime);
    }

    public boolean isBetweenTheseDays(ZonedDateTime startDate, ZonedDateTime endDate) {
        for (ZonedDateTime dateTime = startDate; startDate.isBefore(endDate); dateTime = dateTime.plusDays(1)) {
            if (date.equals(dateTime)) {
                return true;
            }
        }

        return false;
    }
}
