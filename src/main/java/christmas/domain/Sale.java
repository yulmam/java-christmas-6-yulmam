package christmas.domain;

import org.mockito.internal.matchers.Or;

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
}
