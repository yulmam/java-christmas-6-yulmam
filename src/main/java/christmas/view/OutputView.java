package christmas.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printAllPrice(int allPrice) {
        System.out.println("할인 전 총주문 금액");
        System.out.println(allPrice + "원");
    }
}
