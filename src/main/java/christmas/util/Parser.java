package christmas.util;

import christmas.domain.enumeration.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public static int stringToInt(String str) throws IllegalArgumentException{
        try{
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("정수를 입력해 주세요");
        }
    }

    public static Map<Menu, Integer> stringToMap(String str) throws IllegalArgumentException{

        Map<Menu, Integer> map = new HashMap<>();
        String[] splitedStr = str.split(",");

        for(String s : splitedStr){
            String[] str1 = s.split("-");
            if(map.containsKey(Menu.of(str1[0])))
                throw new IllegalArgumentException();
            map.put(Menu.of(str1[0]), stringToInt(str1[1]));
        }

        return map;
    }
}
