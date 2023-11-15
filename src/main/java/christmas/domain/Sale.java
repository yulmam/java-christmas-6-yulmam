package christmas.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Sale {

    private static final int MINIMUM_PRICE = 10000;
    private static final int CHRISTMAS_DAY = 25;
    private static final int CHRISTMAS_SALE_DEFAULT = 900;
    private static final int PRESENT_SALE_MINIMUM = 120000;
    private static final int PRESENT_PRICE = 25000;


    private int christmasSale;
    private int weekendSale;
    private int weekdaySale;
    private int specialSale;
    private int presentSale;



    public Sale(VisitDate visitDate, Order order){
        if(order.calculateAllPrice() >= MINIMUM_PRICE){
            setChristmasSale(visitDate);
            setDateSale(visitDate, order);
            setSpecialSale(visitDate);
            setPresentSale(order);
        }
    }

    private void setChristmasSale(VisitDate visitDate){
        if(visitDate.getDate() > CHRISTMAS_DAY){
            christmasSale = 0;
            return;
        }
        christmasSale = visitDate.getDate() * 100 + CHRISTMAS_SALE_DEFAULT;
    }

    private void setDateSale(VisitDate visitDate, Order order) {
        if(visitDate.getWeek().getIsWeekend()){
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
        if(visitDate.isSpecialSale() || visitDate.getDate() == CHRISTMAS_DAY){
            specialSale = 1000;
        }
    }

    private void setPresentSale(Order order) {
        if(order.calculateAllPrice() > PRESENT_SALE_MINIMUM)
            presentSale = PRESENT_PRICE;
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
        return saleList;
    }

    public int getAllSalePrice(){
        return christmasSale + weekendSale + weekdaySale + specialSale + presentSale;
    }

    public String getBedge() {
        int allSalePrice = getAllSalePrice();
        if(allSalePrice > 20000)
            return "산타";
        if(allSalePrice > 10000)
            return "트리";
        if(allSalePrice > 5000)
            return "별";
        return "없음";
    }

    public boolean isSaleZero(){
        if(getAllSalePrice()==0)
            return true;
        return false;
    }
}
