package br.unicamp.ic.mc322.lab05.reminders;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class WeekDaysReminder extends Reminder {

    private List<DayOfWeek> daysOfWeek;

    private static final String INVALID_WEEK_DAY = "Dia da semana inválido";

    public WeekDaysReminder(String description, List<DayOfWeek> daysOfWeek) {
        super(description);
        this.daysOfWeek = daysOfWeek;
    }


    private String getDaysOfWeek() {
        return daysOfWeek.stream()
                .map(this::getWeekDayNameInPortuguese)
                .collect(Collectors.joining(", "));
    }

    private String getWeekDayNameInPortuguese(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case SUNDAY:
                return "Domingo";
            case MONDAY:
                return "Segunda-feira";
            case TUESDAY:
                return "Terça-feira";
            case WEDNESDAY:
                return "Quarta-feira";
            case THURSDAY:
                return "Quinta-feira";
            case FRIDAY:
                return "Sexta-feira";
            case SATURDAY:
                return "Sábado";
            default:
                return INVALID_WEEK_DAY;
        }
    }

    @Override
    public String toString() {
        return "Lembrete semanal: " +
                getDescription() + ", " +
                "Dias da semana: " + getDaysOfWeek();
    }

    public boolean remindInThisDay(ZonedDateTime dateTime) {
        return daysOfWeek.contains(dateTime.getDayOfWeek());
    }

    public boolean remindBetweenTheseWeekDays(ZonedDateTime startDate, ZonedDateTime endDate) {
        for (ZonedDateTime dateTime = startDate; startDate.isBefore(endDate); dateTime = dateTime.plusDays(1)) {
            if (daysOfWeek.contains(dateTime.getDayOfWeek())) {
                return true;
            }
        }

        return false;
    }
}
