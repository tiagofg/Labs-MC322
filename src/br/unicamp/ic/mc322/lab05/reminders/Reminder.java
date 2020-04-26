package br.unicamp.ic.mc322.lab05.reminders;

public class Reminder {

    private String description;

    public Reminder(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Lembrete comum: " + description;
    }
}
