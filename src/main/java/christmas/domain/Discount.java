package christmas.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Discount {

    private static final int MINIMUM_PRICE = 10000;
    private static final int CHRISTMAS_DAY = 25;
    private static final int CHRISTMAS_SALE_DEFAULT = 900;
    private static final int PRESENT_SALE_MINIMUM = 120000;
    private static final int PRESENT_PRICE = 25000;


    private final Map<String, Integer> discounts = new LinkedHashMap<>();

    private int discountedPrice;

    public Discount(VisitDate visitDate, Order order){
        if(order.calculateAllPrice() >= MINIMUM_PRICE){
            checkChristmasSale(visitDate);
            checkDateSale(visitDate, order);
            checkSpecialSale(visitDate);
            checkPresentSale(order);
        }
        setDiscountedPrice(order);
    }

    private void checkChristmasSale(VisitDate visitDate){
        if(visitDate.getDate() < CHRISTMAS_DAY){
            discounts.put("크리스마스 디데이 할인", visitDate.getDate() * 100 + CHRISTMAS_SALE_DEFAULT);
        }
    }

    private void checkDateSale(VisitDate visitDate, Order order) {
        if(visitDate.isWeekend()){
            discounts.put("주말 할인", order.countMain() * 2023);
        }
        discounts.put("평일 할인", order.countDesert() * 2023);
    }

    private void checkSpecialSale(VisitDate visitDate) {
        if(visitDate.isSunday() || visitDate.getDate() == CHRISTMAS_DAY){
            discounts.put("특별 할인", 1000);
        }
    }

    private void checkPresentSale(Order order){
        if(order.calculateAllPrice() > PRESENT_SALE_MINIMUM)
            discounts.put("증정 이벤트", PRESENT_PRICE);
    }

    private void setDiscountedPrice(Order order) {
        if(isPresent()){
            discountedPrice = order.calculateAllPrice() - sumAllDiscounts() + 25000;
            return;
        }
        discountedPrice = order.calculateAllPrice() - sumAllDiscounts();
    }

    public boolean isPresent(){
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
        int allSalePrice = sumAllDiscounts();
        if(allSalePrice > 20000)
            return "산타";
        if(allSalePrice > 10000)
            return "트리";
        if(allSalePrice > 5000)
            return "별";
        return "없음";
    }
}
