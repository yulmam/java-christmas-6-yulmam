package christmas.exception;

import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.domain.enumeration.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static christmas.util.Parser.stringToInt;
import static christmas.util.Parser.stringToMap;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    @Test
    void 정수가_아닌_경우_테스트 () {
        //given
        String date = "a";

        //then
        assertThatThrownBy(() -> {
            stringToInt(date);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수를 입력해 주세요");
    }

    @Test
    void 날짜의_범위_테스트 () {
        //given
        int date = 100;

        //then
        assertThatThrownBy(() -> {
            new VisitDate(date);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 날자는 1부터 31일 사이어야 합니다.");
    }

    @Test
    void 메뉴에_없는_것을_입력_했을_경우_테스트 () {
        //given
        String order = "국밥-5";

        //then
        assertThatThrownBy(() -> {
            stringToMap(order);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]없는 메뉴입니다.");

    }

    @Test
    void 중복된_메뉴를_입력한_경우_테스트 () {
        //given
        String order = "티본스테이크-2,티본스테이크-1";

        //then
        assertThatThrownBy(() -> {
            stringToMap(order);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 메뉴가 중복 됐습니다.");
    }

    @Test
    void 메뉴가_1개_이상이_아닐_경우_테스트 () {
        //given
        Map<Menu, Integer> order = new HashMap<>();
        order.put(Menu.ZERO_COKE, 0);

        //then
        assertThatThrownBy(() -> {
            new Order(order);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 메뉴는 1개 이상부터 주문이 가능합니다.");
    }

    @Test
    void 음료만_주문한_경우_테스트() {
        //given
        Map<Menu, Integer> order = new HashMap<>();
        order.put(Menu.ZERO_COKE, 5);

        //then
        assertThatThrownBy(() -> {
            new Order(order);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음료만 시킬 수 없습니다.");

    }

    @Test
    void 메뉴를_20개_이상_주문한_경우_테스트(){
        //given
        Map<Menu, Integer> order = new HashMap<>();
        order.put(Menu.ZERO_COKE, 11);
        order.put(Menu.T_BONE_STEAK, 10);

        //when
        assertThatThrownBy(() -> {
            new Order(order);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 메뉴는 최대 20개 까지 주문이 가능합니다.");
    }




}
