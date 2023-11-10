package christmas.controller;

import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        outputView.printStartMessage();
    }

    private VisitDate requestDay(){
        try{
            return new VisitDate(inputView.requestVisitDay());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return requestDay();
        }
    }

}
