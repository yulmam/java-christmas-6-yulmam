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
        Order order = new Order(inputView.requestOrder());
        Sale sale = new Sale(visitDate, order);
        outputView.printOrder(order.getOrder());
        outputView.printAllPrice(order.getAllPrice());
        printSale(sale);
        outputView.printAllSalePrice(sale.getAllSalePrice());
        outputView.printAfterSalePrice(order.getAllPrice()- sale.getAllSalePrice());
        outputView.printBadge(sale.getBedge());

    }

    private VisitDate requestDay(){
        try{
            return new VisitDate(inputView.requestVisitDay());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return requestDay();
        }
    }

    private void printSale(Sale sale){
        outputView.printSaleList(sale.getSaleList());
    }

}
