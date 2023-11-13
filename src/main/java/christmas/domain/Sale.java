package christmas.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Sale {
    private int christmasSale;
    private int weekendSale;
    private int weekdaySale;
    private int specialSale;
    private int presentSale;


    public Sale(VisitDate visitDate, Order order){
        if(order.getAllPrice() > 10000){
            setChristmasSale(visitDate);
            setDateSale(visitDate, order);
            setSpecialSale(visitDate);
            setPresentSale(order);
        }
    }

    private void setChristmasSale(VisitDate visitDate){
        if(visitDate.getDate() > 25){
            christmasSale = 0;
            return;
        }
        christmasSale = (26 - visitDate.getDate()) * 1000;
    }

    private void setDateSale(VisitDate visitDate, Order order) {
        if(visitDate.getWeek().getIsWeekend()){
            setWeekendSale(order);
            System.out.println("test");
            return;
        }
        setWeekdaySale(order);
    }

    private void setWeekendSale(Order order){
        weekendSale = order.getDesertCount() * 2023;
    }

    private void setWeekdaySale(Order order) {
        weekdaySale = order.getMainCount() * 2023;
    }

    private void setSpecialSale(VisitDate visitDate) {
        if(visitDate.isSpecialSale() || visitDate.getDate()==25){
            specialSale = 1000;
        }
    }

    private void setPresentSale(Order order) {
        if(order.getAllPrice()>120000)
            presentSale = 25000;
    }

    public Map<String, Integer> getSaleList() {
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
}
