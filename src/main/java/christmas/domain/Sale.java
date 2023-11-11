package christmas.domain;

import org.mockito.internal.matchers.Or;

public class Sale {
    int christmasSale;
    int weekendSale;
    int weekdaySale;


    public Sale(VisitDate visitDate, Order order){
        setChristmasSale(visitDate);
    }


    private void setChristmasSale(VisitDate visitDate){
        if(visitDate.getDate() > 25){
            christmasSale = 0;
            return;
        }
        christmasSale = (26 - visitDate.getDate()) * 1000;
    }


}
