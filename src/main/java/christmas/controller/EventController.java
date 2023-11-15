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
        printSaleResult(discount, order);
    }

    private VisitDate requestDay(){
        try{
            return new VisitDate(inputView.printRequestVisitDayMessage());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return requestDay();
        }
    }

    private Order requestOrder(){
        try{
            return new Order(inputView.printRequestOrderMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestOrder();
        }
    }

    private void printOrderResult(Order order) {
        outputView.printOrder(order.getOrderContents());
        outputView.printAllPrice(order.calculateAllPrice());
    }

    private void printSaleResult(Discount discount, Order order) {
        outputView.printPresent(discount.isPresent());
        outputView.printSaleList(discount.getDiscounts());
        outputView.printAllSalePrice(discount.sumAllDiscounts());
        outputView.printAfterSalePrice(discount.getDiscountedPrice());
        outputView.printBadge(discount.getBadge());
    }

}
