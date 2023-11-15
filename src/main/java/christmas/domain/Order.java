package christmas.domain;

import christmas.domain.enumeration.Menu;
import christmas.domain.enumeration.MenuClassification;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> order;

    public Order(Map<Menu, Integer> order) throws IllegalArgumentException{
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

    public Map<String, Integer> getOrderContents(){
        Map<String, Integer> orderContents = new HashMap<>();
        order.forEach((key, value) -> orderContents.put(key.getName(), value));
        return orderContents;
    }

    private void validate(Map<Menu, Integer> order) throws IllegalArgumentException{
        validateMenuCountZero(order);
        validateNotNull(order);
        validateOnlyDrink(order);
        validateMenuOver(order);
    }

    private void validateMenuCountZero(Map<Menu, Integer> order) throws IllegalArgumentException{
        if(order.entrySet().stream().anyMatch(o -> o.getValue() < 1))
            throw new IllegalArgumentException("[ERROR] 메뉴는 1개 이상부터 주문이 가능합니다.");
    }

    private void validateNotNull(Map<Menu, Integer> order) throws IllegalArgumentException{
        if(order.isEmpty())
            throw new IllegalArgumentException("[ERROR] 메뉴를 입력해 주세요.");
    }

    private void validateOnlyDrink(Map<Menu, Integer> order) throws IllegalArgumentException{
        if(order.entrySet().stream().allMatch(o -> o.getKey().getMenuClassification() == MenuClassification.BEVERAGE))
            throw new IllegalArgumentException("[ERROR] 음료만 시킬 수 없습니다.");
    }

    private void validateMenuOver(Map<Menu, Integer> order) throws IllegalArgumentException{
        if(order.values().stream().reduce(0, Integer::sum) > 20)
            throw new IllegalArgumentException("[ERROR] 메뉴는 최대 20개 까지 주문이 가능합니다.");
    }


}
