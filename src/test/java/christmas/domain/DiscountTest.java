package christmas.domain;

import christmas.domain.enumeration.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiscountTest {

    private static Discount discount;

    @BeforeAll
    static void setUp() {
        VisitDate visitDate = new VisitDate(25);
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.T_BONE_STEAK, 4);//22만원
        orderMap.put(Menu.CHOCOLATE_CAKE, 3);//4만 5천원
        Order order = new Order(orderMap);
        discount = new Discount(visitDate, order);
    }

    @Test
    void 증정이벤트_테스트() {
        //then
        assertTrue(discount.isPresentDiscount());//결제 금액은 25만 5천원으로 증정이벤트인 12만원을 넘어간다.
    }

    @Test
    void 할인금액_테스트() {
        //then
        assertEquals(discount.sumAllDiscounts(), 32069);//평일 할인 6066원, 특별 할인 1000원, 증정 이벤트 25000입니다.
    }

    @Test
    void 배지_테스트() {
        //then
        assertEquals(discount.getBadge(), "산타");//할인 금액이 32069로 혜택은 산타입니다.
    }

    @Test
    void 최소_주문금액_테스트() {
        //given
        VisitDate visitDate = new VisitDate(25);
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.ICE_CREAM, 1);
        Order order = new Order(orderMap);
        Discount discount = new Discount(visitDate, order);

        //then
        assertTrue(discount.getDiscounts().isEmpty());
    }
}
