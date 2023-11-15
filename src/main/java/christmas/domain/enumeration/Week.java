package christmas.domain.enumeration;

import java.util.Arrays;

public enum Week {
    MON(1),
    TUE(2),
    WED(3),
    THU(4),
    FRI(5),
    SAT(6),
    SUN(7);


    private final int dayValue;

    Week(int dayValue) {
        this.dayValue = dayValue;
    }

    public static Week of(int dayValue){
        return Arrays.stream(Week.values())
                .filter(d -> d.dayValue == dayValue)
                .findFirst()
                .orElse(null);
    }
}
