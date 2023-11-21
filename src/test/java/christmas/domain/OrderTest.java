package christmas.domain;

import christmas.domain.enumeration.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @Test
    void 메인메뉴_계산_테스트(){
        //given
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.BARBECUE_RIBS, 5);
        orderMap.put(Menu.T_BONE_STEAK, 3);
        Order order = new Order(orderMap);

        //then
        assertEquals(order.countMain(), 8);
    }

    @Test
    void 디저트메뉴_계산_테스트(){
        //given
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.CHOCOLATE_CAKE, 3);
        orderMap.put(Menu.ICE_CREAM, 2);
        Order order = new Order(orderMap);

        //then
        assertEquals(order.countDesert(), 5);
    }

    @Test
    void 주문가격_계산_테스트(){
        //given
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.T_BONE_STEAK, 3);//티본 스테이크 3개 165000원
        orderMap.put(Menu.ICE_CREAM, 2);//아이스크림 2개 10000원
        orderMap.put(Menu.ZERO_COKE, 2);//제로콜라 2개 6000원
        Order order = new Order(orderMap);

        //then
        assertEquals(order.calculateAllPrice(), 181000);//165000 + 10000 + 6000
    }
}
