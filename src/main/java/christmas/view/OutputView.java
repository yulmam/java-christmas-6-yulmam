package christmas.view;

import christmas.domain.enumeration.Menu;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printDayMessage(int day) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public void printOrder(Map<String, Integer> orderContents){
        System.out.println("<주문 메뉴>");
        orderContents.forEach((key, value) -> System.out.println(key + " " + value + "개"));
        System.out.println();
    }

    public void printAllPrice(int allPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(decimalFormat.format(allPrice) + "원\n");
    }

    public void printPresent(boolean isPresent){
        System.out.println("<증정 메뉴>");
        if(isPresent){
            System.out.println("샴페인 1개\n");
            return;
        }
        printNothing();
    }


    public void printSaleList(Map<String, Integer> saleList){
        System.out.println("<혜택 내역>");
        if(saleList.isEmpty()){
            printNothing();
            return;
        }
        saleList.forEach((key, value)-> System.out.println(key+": " + decimalFormat.format(-value) + "원"));
        System.out.println();
    }

    public void printAllSalePrice(int price){
        System.out.println("<총혜택 금액>");
        System.out.println(decimalFormat.format(-price) + "원\n");
    }

    public void printAfterSalePrice(int price) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(decimalFormat.format(price) + "원\n");
    }

    public void printBadge(String Badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(Badge);
    }

    private void printNothing(){
        System.out.println("없음\n");
    }
}
