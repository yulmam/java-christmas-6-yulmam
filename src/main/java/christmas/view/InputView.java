package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int requestVisitDay(){
        System.out.println("12월 중 예상 방문 날짜는 언제인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
