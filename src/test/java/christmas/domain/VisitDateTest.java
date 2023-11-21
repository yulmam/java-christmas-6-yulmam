package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VisitDateTest {

    @Test
    void 주말_평일_구분_테스트(){
        //given
        VisitDate visitDate1 = new VisitDate(23);//토요일
        VisitDate visitDate2 = new VisitDate(25);//월요일

        //then
        assertTrue(visitDate1.isWeekend());
        assertFalse(visitDate2.isWeekend());
    }

    @Test
    void 일요일인지_확인_테스트() {
        //given
        VisitDate visitDate1 = new VisitDate(24);//일요일
        VisitDate visitDate2 = new VisitDate(25);//월요일

        //then
        assertTrue(visitDate1.isSunday());
        assertFalse(visitDate2.isSunday());
    }
}
