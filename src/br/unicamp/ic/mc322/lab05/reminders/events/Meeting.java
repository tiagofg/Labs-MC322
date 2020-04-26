package br.unicamp.ic.mc322.lab05.reminders.events;

import br.unicamp.ic.mc322.lab05.reminders.events.person.Person;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Meeting extends Event {

    private List<Person> people;

    public Meeting(String description, ZonedDateTime date, List<Person> people) {
        super(description, date);
        this.people = people;
    }

    private String getPeopleName() {
        return people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Reunião: " +
                getDescription() + ", " +
                "Data: " + getDate().format(formatter) + ", " +
                "Pessoas: " + getPeopleName();
    }

    public boolean isInTheMeeting(Person person) {
        for (Person p : people) {
            if (p.equals(person)) {
                return true;
            }
        }

        return false;
    }
}
