package christmas.controller;

import christmas.domain.Sale;
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
        printOrderResult(order);
        Sale sale = new Sale(visitDate, order);
        printSaleResult(sale);
        outputView.printAfterSalePrice(order.calculateAllPrice()- sale.getAllSalePrice());
        outputView.printBadge(sale.getBedge());
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
        outputView.printOrder(order.getOrder());
        outputView.printAllPrice(order.calculateAllPrice());

    }

    private void printSaleResult(Sale sale){
        outputView.printSaleList(sale.getSaleDetails());
        outputView.printAllSalePrice(sale.getAllSalePrice());
    }

}
