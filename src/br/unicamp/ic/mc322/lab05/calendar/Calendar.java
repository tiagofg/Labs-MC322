package br.unicamp.ic.mc322.lab05.calendar;

import br.unicamp.ic.mc322.lab05.reminders.events.person.Person;
import br.unicamp.ic.mc322.lab05.reminders.MonthlyReminder;
import br.unicamp.ic.mc322.lab05.reminders.Reminder;
import br.unicamp.ic.mc322.lab05.reminders.WeekDaysReminder;
import br.unicamp.ic.mc322.lab05.reminders.events.Event;
import br.unicamp.ic.mc322.lab05.reminders.events.Meeting;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Calendar {

    private List<Reminder> reminders;
    private GregorianCalendar calendar;

    public Calendar() {
        reminders = new ArrayList<>();
        calendar = new GregorianCalendar();
    }

    public void addReminder(Reminder reminder) {
        if (reminders.contains(reminder)) {
            System.err.println("Lembrete já inserido.");
            return;
        }

        reminders.add(reminder);
    }

    public void cancelReminder(Reminder reminder) {
        if (!reminders.contains(reminder)) {
            System.err.println("Impossível remover, lembrete não inserido.");
            return;
        }

        reminders.remove(reminder);
    }

    public boolean isInTheMeeting(Person person) {
        for (Reminder reminder : reminders) {
            if (reminder instanceof Meeting && ((Meeting) reminder).isInTheMeeting(person)) {
                return true;
            }
        }

        return false;
    }

    public void getTodayReminders() {
        ZonedDateTime today = calendar.toZonedDateTime();

        getRemindersFromThisDay(today);
    }

    public void getRemindersFromThisDay(ZonedDateTime day) {
        if (day == null) {
            System.err.println("A data não pode ser nula!!");
            return;
        }

        for (Reminder reminder : reminders) {

            if (reminder.getClass().equals(Reminder.class) ||
                    (reminder.getClass().equals(MonthlyReminder.class) &&
                            ((MonthlyReminder) reminder).isInThisMonth(day)) ||
                    (reminder.getClass().equals(WeekDaysReminder.class) &&
                            ((WeekDaysReminder) reminder).remindInThisDay(day)) ||
                    (reminder.getClass().equals(Event.class) &&
                            ((Event) reminder).isInThisDay(day)) ||
                    (reminder.getClass().equals(Meeting.class) &&
                            ((Meeting) reminder).isInThisDay(day))) {

                System.out.println(reminder);
            }
        }

        System.out.println("\n");
    }

    public void getRemindersBetweenTheseDays(ZonedDateTime startDay, ZonedDateTime endDay) {
        if (startDay == null || endDay == null) {
            System.err.println("As datas não podem ser nulas!!");
            return;
        } else if (endDay.isBefore(startDay)) {
            System.err.println("A segunda data não pode ser anterior a primeira!!");
            return;
        }

        for (Reminder reminder : reminders) {

            if (reminder.getClass().equals(Reminder.class) ||
                    (reminder.getClass().equals(MonthlyReminder.class) &&
                            ((MonthlyReminder) reminder).isBetweenTheseMonths(startDay, endDay)) ||
                    (reminder.getClass().equals(WeekDaysReminder.class) &&
                            ((WeekDaysReminder) reminder).remindBetweenTheseWeekDays(startDay, endDay)) ||
                    (reminder.getClass().equals(Event.class) &&
                            ((Event) reminder).isBetweenTheseDays(startDay, endDay)) ||
                    (reminder.getClass().equals(Meeting.class) &&
                            ((Meeting) reminder).isBetweenTheseDays(startDay, endDay))) {

                System.out.println(reminder);
            }
        }

        System.out.println("\n");
    }
}
