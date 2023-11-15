package christmas.domain;

import christmas.domain.enumeration.Week;

import java.time.LocalDate;

public class VisitDate {
    private static final int MAXIMUM_DAY = 31;
    private static final int MINIMUM_DAY = 1;
    private static final int YEAR = 2023;
    private static final int MONTH = 12;


    private final int date;
    private final Week week;

    public VisitDate(int date) throws IllegalArgumentException{
        validate(date);
        this.date = date;
        this.week = Week.of(getWeekNumber(date));
    }

    public boolean isSunday(){
        return week.equals(Week.SUN);
    }

    public int getDate(){
        return date;
    }

    public boolean isWeekend() {
        if(week.equals(Week.FRI) || week.equals(Week.SAT))
            return true;
        return false;
    }

    private void validate(int date) throws IllegalArgumentException {
        if(date < MINIMUM_DAY || date > MAXIMUM_DAY)
            throw new IllegalArgumentException("[ERROR] 날자는 1부터 31일 사이어야 합니다.");
    }

    private int getWeekNumber(int date) {
        LocalDate week = LocalDate.of(YEAR, MONTH, date);
        return week.getDayOfWeek().getValue();
    }
}
