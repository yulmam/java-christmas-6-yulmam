package christmas.domain.enumeration;

import java.util.Arrays;

public enum Week {
    MON(1, false, false),
    TUE(2, false, false),
    WED(3, false, false),
    THU(4, false, false),
    FRI(5, true, false),
    SAT(6, true, false),
    SUN(7, false, true);;


    int dayValue;
    boolean isWeekend;
    boolean isSpecial;

    Week(int dayValue, boolean isWeekend, boolean isSpecial) {
        this.dayValue = dayValue;
        this.isWeekend = isWeekend;
        this.isSpecial = isSpecial;
    }

    public static Week of(int dayValue){
        return Arrays.stream(Week.values())
                .filter(d -> d.dayValue == dayValue)
                .findFirst()
                .orElse(null);
    }

    public boolean getIsWeekend(){
        return isWeekend;
    }

}
