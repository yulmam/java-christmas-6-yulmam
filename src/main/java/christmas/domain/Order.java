package christmas.domain;

import christmas.domain.enumeration.Menu;

import java.util.Map;

public class Order {
    Map<Menu, Integer> order;

    public Order(Map<Menu, Integer> order) {
        validate(order);
        this.order = order;
    }

    private void validate(Map<Menu, Integer> order){
        validateMenuCountZero(order);
        validateNotNull(order);
    }

    private void validateMenuCountZero(Map<Menu, Integer> order) {
        if(order.entrySet().stream().anyMatch(o -> o.getValue() < 1));
            throw new IllegalArgumentException();
    }

    private void validateNotNull(Map<Menu, Integer> order) {
        if(order.isEmpty())
            throw new IllegalArgumentException();
    }


}
