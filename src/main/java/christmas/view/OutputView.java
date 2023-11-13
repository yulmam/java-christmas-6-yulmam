package christmas.view;

import christmas.domain.enumeration.Menu;

import java.util.Map;

public class OutputView {

    public void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printAllPrice(int allPrice) {
        System.out.println("할인 전 총주문 금액");
        System.out.println(allPrice + "원");
    }

    public void printOrder(Map<Menu, Integer> order){
        System.out.println("<주문 메뉴>");
        order.forEach((key, value) -> System.out.println(key.getName() + " " + value + "개"));
    }
    public void printSaleList(Map<String, Integer> saleList){
        System.out.println("<해택 내역>");
        saleList.entrySet()
                .forEach(e-> System.out.println(e.getKey()+": -"+e.getValue()+"원"));
    }
}
