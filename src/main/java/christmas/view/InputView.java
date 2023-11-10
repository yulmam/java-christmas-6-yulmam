package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.util.Parser.stringToInt;

public class InputView {

    public int requestVisitDay() throws IllegalArgumentException{
        System.out.println("12월 중 예상 방문 날짜는 언제인가요?");
        return stringToInt(Console.readLine());
    }
}
