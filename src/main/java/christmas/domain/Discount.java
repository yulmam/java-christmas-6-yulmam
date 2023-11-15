package christmas.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Discount {

    private static final int MINIMUM_PRICE = 10000;
    private static final int CHRISTMAS_YEAR = 2023;
    private static final int CHRISTMAS_DAY = 25;
    private static final int SPECIAL_DISCOUNT = 1000;
    private static final int CHRISTMAS_SALE_DEFAULT = 900;
    private static final int PRESENT_SALE_MINIMUM = 120000;
    private static final int PRESENT_DISCOUNT = 25000;
    private static final int STAR_MINIMUM = 5000;
    private static final int TREE_MINIMUM = 10000;
    private static final int SANTA_MINIMUM = 20000;



    private final Map<String, Integer> discounts = new LinkedHashMap<>();

    private int discountedPrice;

    public Discount(VisitDate visitDate, Order order){
        if(order.calculateAllPrice() >= MINIMUM_PRICE){
            checkDiscounts(visitDate, order);
        }
        setDiscountedPrice(order);
    }

    private void checkDiscounts(VisitDate visitDate, Order order) {
        checkChristmasDiscount(visitDate);
        checkDateDiscount(visitDate, order);
        checkSpecialDiscount(visitDate);
        checkPresentDiscount(order);
    }

    private void checkChristmasDiscount(VisitDate visitDate){
        if(visitDate.getDate() < CHRISTMAS_DAY){
            discounts.put("크리스마스 디데이 할인", visitDate.getDate() * 100 + CHRISTMAS_SALE_DEFAULT);
        }
    }

    private void checkDateDiscount(VisitDate visitDate, Order order) {
        if(visitDate.isWeekend() && order.countMain() != 0){
            discounts.put("주말 할인", order.countMain() * CHRISTMAS_YEAR);
            return;
        }
        if(!visitDate.isWeekend() && order.countDesert() != 0)
            discounts.put("평일 할인", order.countDesert() * CHRISTMAS_YEAR);
    }

    private void checkSpecialDiscount(VisitDate visitDate) {
        if(visitDate.isSunday() || visitDate.getDate() == CHRISTMAS_DAY){
            discounts.put("특별 할인", SPECIAL_DISCOUNT);
        }
    }

    private void checkPresentDiscount(Order order){
        if(order.calculateAllPrice() > PRESENT_SALE_MINIMUM)
            discounts.put("증정 이벤트", PRESENT_DISCOUNT);
    }

    private void setDiscountedPrice(Order order) {
        if(isPresentDiscount()){
            discountedPrice = order.calculateAllPrice() - sumAllDiscounts() + PRESENT_DISCOUNT;
            return;
        }
        discountedPrice = order.calculateAllPrice() - sumAllDiscounts();
    }

    public boolean isPresentDiscount(){
        return discounts.containsKey("증정 이벤트");
    }

    public Map<String, Integer> getDiscounts() {
        return Collections.unmodifiableMap(discounts);
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }
    public int sumAllDiscounts(){
        return discounts.values().stream().mapToInt(Integer::intValue).sum();
    }

    public String getBadge() {
        int allDiscountsPrice = sumAllDiscounts();
        if(allDiscountsPrice > SANTA_MINIMUM)
            return "산타";
        if(allDiscountsPrice > TREE_MINIMUM)
            return "트리";
        if(allDiscountsPrice > STAR_MINIMUM)
            return "별";
        return "없음";
    }
}
