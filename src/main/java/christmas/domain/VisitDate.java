package christmas.domain;

import christmas.domain.enumeration.Week;

import java.time.LocalDate;

public class VisitDate {
    private final int date;
    private final Week week;

    public VisitDate(int date) throws IllegalArgumentException{
        validate(date);
        this.date = date;
        this.week = Week.of(getWeekNumber(date));
    }

    private void validate(int date) throws IllegalArgumentException {
        if(date < 1 || date > 31)
            throw new IllegalArgumentException("[ERROR] 날자는 1부터 31일 사이어야 합니다.");
    }

    public int getDate(){
        return date;
    }

    public boolean isWeekend() {
        if(week.equals(Week.FRI) || week.equals(Week.SAT))
            return true;
        return false;
    }

    private int getWeekNumber(int date) {
        LocalDate week = LocalDate.of(2023, 12, date);
        return week.getDayOfWeek().getValue();
    }

    public boolean isSunday(){
        return week.equals(Week.SUN);
    }
}
