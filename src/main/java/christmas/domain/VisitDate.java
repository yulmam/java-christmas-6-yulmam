package christmas.domain;

import christmas.domain.enumeration.Week;

import java.time.LocalDate;

public class VisitDate {
    private final int date;
    private final Week week;

    public VisitDate(int date){
        validate(date);
        this.date = date;
        this.week = Week.of(getWeekNumber(date));
    }

    private void validate(int date) throws IllegalArgumentException {
        if(date<1 || date>31)
            throw new IllegalArgumentException("날짜는 1일 부터 31일 까지입니다.");
    }

    public int getDate(){
        return date;
    }

    public Week getWeek(){
        return week;
    }

    private int getWeekNumber(int date) {
        LocalDate week = LocalDate.of(2021, 12, date);
        return week.getDayOfWeek().getValue();
    }

    public boolean isSpecialSale(){
        return week.getIsSpecial();
    }

}
