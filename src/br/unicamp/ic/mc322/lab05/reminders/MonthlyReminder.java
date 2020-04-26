package br.unicamp.ic.mc322.lab05.reminders;

import java.time.Month;
import java.time.ZonedDateTime;

public class MonthlyReminder extends Reminder {

    private Month month;

    private static final String INVALID_MONTH = "Mês inválido";

    public MonthlyReminder(String description, Month month) {
        super(description);
        this.month = month;
    }

    private String getMonthNameInPortuguese() {
        switch (month) {
            case JANUARY:
                return "Janeiro";
            case FEBRUARY:
                return "Fevereiro";
            case MARCH:
                return "Março";
            case APRIL:
                return "Abril";
            case MAY:
                return "Maio";
            case JUNE:
                return "Junho";
            case JULY:
                return "Julho";
            case AUGUST:
                return "Agosto";
            case SEPTEMBER:
                return "Setembro";
            case OCTOBER:
                return "Outubro";
            case NOVEMBER:
                return "Novembro";
            case DECEMBER:
                return "Dezembro";
            default:
                return INVALID_MONTH;
        }
    }

    @Override
    public String toString() {
        return "Lembrete mensal: " +
                getDescription() + ", " +
                "Mês: " + getMonthNameInPortuguese();
    }

    public boolean isInThisMonth(ZonedDateTime dateTime) {
        return dateTime.getMonth().equals(month);
    }

    public boolean isBetweenTheseMonths(ZonedDateTime startDate, ZonedDateTime endDate) {
        Month startMonth = startDate.getMonth();
        Month endMonth = endDate.getMonth();

        if (startMonth.getValue() >= endMonth.getValue()) {
            for (int i = startMonth.getValue(); i <= endMonth.getValue(); i++) {
                if (Month.of(i).equals(month)) {
                    return true;
                }
            }
        } else {
            //caso onde as duas datas estão em anos diferentes
            for (int i = startMonth.getValue(); i <= Month.DECEMBER.getValue(); i++) {
                if (Month.of(i).equals(month)) {
                    return true;
                }
            }

            for (int i = Month.JANUARY.getValue(); i <= endMonth.getValue(); i++) {
                if (Month.of(i).equals(month)) {
                    return true;
                }
            }
        }

        return false;
    }
}
