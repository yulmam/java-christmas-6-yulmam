package christmas.domain.enumeration;

import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6500, MenuClassification.APPETIZER),
    TAPAS("타파스", 5500, MenuClassification.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuClassification.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MenuClassification.MAIN),
    BARBECUE_RIBS("바비큐립", 54000, MenuClassification.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuClassification.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuClassification.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, MenuClassification.DESERT),
    ICE_CREAM("아이스크림", 5000, MenuClassification.DESERT),
    ZERO_COKE("제로콜라", 3000, MenuClassification.BEVERAGE),
    RED_WINE("레드와인", 60000, MenuClassification.BEVERAGE),
    CHAMPAGNE("샴페인", 25000, MenuClassification.BEVERAGE);

    private final String name;
    private final int price;
    private final MenuClassification menuClassification;

    Menu(String name, int price, MenuClassification menuClassification){
        this.name = name;
        this.price = price;
        this.menuClassification = menuClassification;
    }

    public static Menu of(String name) throws IllegalArgumentException{
        Menu menu =  Arrays.stream(Menu.values())
                .filter(m -> m.name.equals(name))
                .findFirst()
                .orElse(null);
        if(menu == null)
            throw new IllegalArgumentException("[ERROR]없는 메뉴입니다.");
        return menu;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public boolean isDesert(){
        if(menuClassification == MenuClassification.DESERT)
            return true;
        return false;
    }

    public boolean isMain(){
        if(menuClassification == MenuClassification.MAIN)
            return true;
        return false;
    }

    public boolean isBeverage() {
        if(menuClassification == MenuClassification.BEVERAGE)
            return true;
        return false;
    }
}
