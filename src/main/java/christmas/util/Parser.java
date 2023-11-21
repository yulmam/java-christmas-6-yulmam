package christmas.util;

import christmas.domain.enumeration.Menu;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    private static final String FIRST_SEPARATOR = ",";
    private static final String SECOND_SEPARATOR = "-";
    private static final int MENU = 0;
    private static final int COUNT = 1;

    public static int stringToInt(String str) throws IllegalArgumentException{
        try{
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요");
        }
    }

    public static Map<Menu, Integer> stringToMap(String str) throws IllegalArgumentException{
        String[] splitStrings = splitFirst(str);
        return splitSecond(splitStrings);
    }

    private static String[] splitFirst(String str){
        return str.split(FIRST_SEPARATOR);
    }

    private static Map<Menu, Integer> splitSecond(String[] splitStrings) throws IllegalArgumentException{
        Map<Menu, Integer> map = new HashMap<>();
        for(String s : splitStrings){
            String[] str = s.split(SECOND_SEPARATOR);
            if(map.containsKey(Menu.of(str[MENU])))
                throw new IllegalArgumentException("[ERROR] 메뉴가 중복 됐습니다.");
            map.put(Menu.of(str[MENU]), stringToInt(str[COUNT]));
        }
        return map;
    }
}
