package christmas.util;

public class Parser {

    public static int stringToInt(String str) throws  IllegalArgumentException{
        try{
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("정수를 입력해 주세요");
        }
    }
}
