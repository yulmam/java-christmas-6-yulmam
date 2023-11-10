package christmas.domain;

import christmas.domain.enumeration.Menu;

import java.util.Map;

public class Order {
    Map<Menu, Integer> order;

    public Order(Map<Menu, Integer> order) {
        this.order = order;
    }
}
