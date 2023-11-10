package christmas.domain;

public class Sale {
    int christmasSale;


    public void setChristmasSale(VisitDate visitDate){
        if(visitDate.getDate() < 26)
            christmasSale = (26 - visitDate.getDate()) * 1000;
        christmasSale = 0;
    }


}
