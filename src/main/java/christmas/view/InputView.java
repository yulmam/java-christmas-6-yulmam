package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.enumeration.Menu;

import java.util.Map;

import static christmas.util.Parser.stringToInt;
import static christmas.util.Parser.stringToMap;

public class InputView {

    public int printRequestVisitDayMessage() throws IllegalArgumentException{
        System.out.println("12월 중 예상 방문 날짜는 언제인가요?");
        return stringToInt(Console.readLine());
    }

    public Map<Menu, Integer> printRequestOrderMessage() throws IllegalArgumentException{
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return stringToMap(Console.readLine());
    }
}
