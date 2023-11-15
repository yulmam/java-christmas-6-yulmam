package christmas.domain.enumeration;

import java.util.Arrays;

public enum Week {
    MON(1, false),
    TUE(2, false),
    WED(3, false),
    THU(4, false),
    FRI(5, true),
    SAT(6, true),
    SUN(7, false);;


    private final int dayValue;
    private final boolean isWeekend;

    Week(int dayValue, boolean isWeekend) {
        this.dayValue = dayValue;
        this.isWeekend = isWeekend;
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
