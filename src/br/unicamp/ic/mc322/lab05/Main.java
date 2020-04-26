package br.unicamp.ic.mc322.lab05;

import br.unicamp.ic.mc322.lab05.calendar.Calendar;
import br.unicamp.ic.mc322.lab05.reminders.events.person.Person;
import br.unicamp.ic.mc322.lab05.reminders.MonthlyReminder;
import br.unicamp.ic.mc322.lab05.reminders.Reminder;
import br.unicamp.ic.mc322.lab05.reminders.WeekDaysReminder;
import br.unicamp.ic.mc322.lab05.reminders.events.Event;
import br.unicamp.ic.mc322.lab05.reminders.events.Meeting;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Calendar calendar = new Calendar();

        Reminder reminder = new Reminder("Lembrete comum");

        calendar.addReminder(reminder);

        calendar.addReminder(new MonthlyReminder("Lembrete mensal", Month.APRIL));
        calendar.addReminder(new MonthlyReminder("Lembrete mensal março", Month.MARCH));

        List<DayOfWeek> daysOfWeek = Arrays.asList(DayOfWeek.THURSDAY, DayOfWeek.SATURDAY);
        calendar.addReminder(new WeekDaysReminder("Lembrente semanal", daysOfWeek));

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime today = gregorianCalendar.toZonedDateTime();

        gregorianCalendar.set(2020, java.util.Calendar.MARCH, 23);
        ZonedDateTime marchDay = gregorianCalendar.toZonedDateTime();

        calendar.addReminder(new Event("Evento", today));
        calendar.addReminder(new Event("Evento março", marchDay));

        Person joao = new Person("João", "joao@gmail.com", "123456");
        Person maria = new Person("Maria", "maria@gmail.com", "123456");
        List<Person> people = Arrays.asList(joao, maria);
        calendar.addReminder(new Meeting("Reunião", today, people));

        if (calendar.isInTheMeeting(new Person("João", "joao@gmail.com", "123456"))) {
            System.out.println("João está na reunião.");
        }

        calendar.getTodayReminders();

        calendar.getRemindersFromThisDay(marchDay);

        calendar.cancelReminder(reminder);

        calendar.getRemindersBetweenTheseDays(marchDay, today);

    }

}
