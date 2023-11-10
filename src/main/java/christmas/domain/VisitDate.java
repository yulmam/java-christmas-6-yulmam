package christmas.domain;

public class VisitDate {
    private final int date;

    public VisitDate(int date){
        validate(date);
        this.date = date;
    }

    private void validate(int date) throws IllegalArgumentException {
        if(date<1 || date>31)
            throw new IllegalArgumentException("날짜는 1일 부터 31일 까지입니다.");
    }

    public int getDate(){
        return date;
    }

}
