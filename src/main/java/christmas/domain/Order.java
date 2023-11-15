package christmas.domain;

import christmas.domain.enumeration.Menu;
import christmas.domain.enumeration.MenuClassification;

import java.util.Collections;
import java.util.Map;

public class Order {
    Map<Menu, Integer> order;

    public Order(Map<Menu, Integer> order) {
        validate(order);
        this.order = order;
    }

    public int countDesert() {
        return order.entrySet().stream()
                .filter(o-> o.getKey().getMenuClassification() == MenuClassification.DESERT)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public int countMain() {
        return order.entrySet().stream()
                .filter(o-> o.getKey().getMenuClassification() == MenuClassification.MAIN)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public int calculateAllPrice(){
        return order.entrySet().stream()
                .mapToInt(e->e.getKey().getPrice() * e.getValue())
                .sum();
    }

    public Map<Menu, Integer> getOrder(){
        return Collections.unmodifiableMap(order);
    }

    private void validate(Map<Menu, Integer> order){
        validateMenuCountZero(order);
        validateNotNull(order);
        validateOnlyDrink(order);
        validateMenuOver(order);
    }

    private void validateMenuCountZero(Map<Menu, Integer> order) {
        if(order.entrySet().stream().anyMatch(o -> o.getValue() < 1))
            throw new IllegalArgumentException();
    }

    private void validateNotNull(Map<Menu, Integer> order) {
        if(order.isEmpty())
            throw new IllegalArgumentException();
    }

    private void validateOnlyDrink(Map<Menu, Integer> order) {
        if(order.entrySet().stream().allMatch(o -> o.getKey().getMenuClassification() == MenuClassification.BEVERAGE))
            throw new IllegalArgumentException();
    }

    private void validateMenuOver(Map<Menu, Integer> order) {
        if(order.values().stream().reduce(0, Integer::sum)>20)
            throw new IllegalArgumentException();
    }


}
