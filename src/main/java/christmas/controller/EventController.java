package christmas.controller;

import christmas.domain.Discount;
import christmas.domain.VisitDate;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        outputView.printStartMessage();

        VisitDate visitDate = requestDay();

        Order order = requestOrder();

        outputView.printDayMessage(visitDate.getDate());

        printOrderResult(order);

        Discount discount = new Discount(visitDate, order);

        printDiscountResult(discount);
    }

    private VisitDate requestDay(){
        try{
            return new VisitDate(inputView.printRequestVisitDayMessage());
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return requestDay();
        }
    }

    private Order requestOrder(){
        try{
            return new Order(inputView.printRequestOrderMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            return requestOrder();
        }
    }

    private void printOrderResult(Order order) {
        outputView.printOrder(order.getOrderContents());
        outputView.printAllPrice(order.calculateAllPrice());
    }

    private void printDiscountResult(Discount discount) {
        outputView.printPresent(discount.isPresentDiscount());
        outputView.printSaleList(discount.getDiscounts());
        outputView.printAllSalePrice(discount.sumAllDiscounts());
        outputView.printAfterSalePrice(discount.getDiscountedPrice());
        outputView.printBadge(discount.getBadge());
    }

}
