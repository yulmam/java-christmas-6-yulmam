package christmas.controller;

import christmas.domain.Day;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        outputView.printStartMessage();
        Day day = new Day(inputView.requestVisitDay());
    }

}
