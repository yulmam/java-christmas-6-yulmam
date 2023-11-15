package christmas.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Discount {

    private static final int MINIMUM_PRICE = 10000;
    private static final int CHRISTMAS_DAY = 25;
    private static final int CHRISTMAS_SALE_DEFAULT = 900;
    private static final int PRESENT_SALE_MINIMUM = 120000;
    private static final int PRESENT_PRICE = 25000;


    private Map<String, Integer> discounts;
    private int christmasSale;
    private int weekendSale;
    private int weekdaySale;
    private int specialSale;
    private int presentSale;

    private int discountedPrice;



    public Discount(VisitDate visitDate, Order order){
        if(order.calculateAllPrice() >= MINIMUM_PRICE){
            setChristmasSale(visitDate);
            setDateSale(visitDate, order);
            setSpecialSale(visitDate);
            setPresentSale(order);
        }
        setDiscountedPrice(order);
    }

    private void setChristmasSale(VisitDate visitDate){
        if(visitDate.getDate() > CHRISTMAS_DAY){
            christmasSale = 0;
            return;
        }
        christmasSale = visitDate.getDate() * 100 + CHRISTMAS_SALE_DEFAULT;
    }

    private void setDateSale(VisitDate visitDate, Order order) {
        if(visitDate.isWeekend()){
            setWeekendSale(order);
            return;
        }
        setWeekdaySale(order);
    }

    private void setWeekendSale(Order order){
        weekendSale = order.countMain() * 2023;
    }

    private void setWeekdaySale(Order order) {
        weekdaySale = order.countDesert() * 2023;
    }

    private void setSpecialSale(VisitDate visitDate) {
        if(visitDate.isSunday() || visitDate.getDate() == CHRISTMAS_DAY){
            specialSale = 1000;
        }
    }

    private void setPresentSale(Order order) {
        if(order.calculateAllPrice() > PRESENT_SALE_MINIMUM)
            presentSale = PRESENT_PRICE;
    }

    private void setDiscountedPrice(Order order){
        discountedPrice = order.calculateAllPrice() - getAllDiscountPrice();
    }

    public Map<String, Integer> getSaleDetails() {
        Map<String, Integer> saleList = new LinkedHashMap<>();
        if(christmasSale != 0)
            saleList.put("크리스마스 디데이 할인", christmasSale);
        if(weekdaySale != 0)
            saleList.put("평일 할인", weekdaySale);
        if(weekendSale != 0)
            saleList.put("주말 할인", weekendSale);
        if(specialSale != 0)
            saleList.put("특별 할인", specialSale);
        if(presentSale != 0)
            saleList.put("증정 이벤트", presentSale);
        if(saleList.isEmpty())
            saleList.put("없음", null);
        return saleList;
    }

    public int getAllDiscountPrice(){
        return christmasSale + weekendSale + weekdaySale + specialSale + presentSale;
    }

    public String getBedge() {
        int allSalePrice = getAllDiscountPrice();
        if(allSalePrice > 20000)
            return "산타";
        if(allSalePrice > 10000)
            return "트리";
        if(allSalePrice > 5000)
            return "별";
        return "없음";
    }

    public int getDiscountedPrice(){
        return discountedPrice;
    }

}
