package christmas.validate;

import christmas.exception.*;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public static void validateInputBlank(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException();
        }
    }

    public static void validateOnlyNumber(int input){
        String inputString = Integer.toString(input);

        if (!inputString.matches("\\d+")) {
            throw new NonNumericInputException();
        }
    }


    // 메뉴를 주문하지 않은 경우
    public static void validateZero(Map<String, Integer> orderList){
        if(orderList.isEmpty()){
            throw new ZeroMenuException();
        }
    }

    // 수량 0 체크
    public static void validateQuantityZero(Map<String,Integer> inputMenu){
        if(inputMenu.containsValue(0)){
            throw new ZeroMenuException();
        }
    }

    // 중복메뉴체크
    public static void validateDuplicateMenu(Map<String,Integer> inputMenu){
        Set temp = inputMenu.entrySet();
        if(temp.size() != inputMenu.size()){
            throw new DuplicateMenuException();
        }
    }

    // 음료만 주문한 경우
    public static void validateOnlyDrink(Map<String, Integer> inputMenu, Map<String, Integer> drink) {
        boolean hasNonDrink = false;

        for (String menuName : inputMenu.keySet()) {
            if (!drink.containsKey(menuName)) {
                hasNonDrink = true;
                break;
            }
        }

        if (!hasNonDrink) {
            throw new OnlyDrinkException();
        }
    }

    // 총 주문 개수가 20개 초과된 경우
    public static void validateQuantity20(Map<String,Integer> inputMenu){
        int orderAmount = 0;
        for(int i=0; i<inputMenu.size(); i++){
            orderAmount += inputMenu.get(i);
        }

        if(orderAmount>20){
            throw new Quantity20Exception();
        }
    }

    // 메뉴판에 없는 경우
    public static void validateNoneMenu(Map<String, Integer> inputMenu, Map<String, Integer> allMenu) {
        if (!inputMenu.keySet().removeAll(allMenu.keySet())) {
            throw new NoneMenuException();
        }
    }

    // 주문형식이 잘못된 경우
    public static void validateInputPattern(String input){
        Pattern pattern = Pattern.compile("[a-zA-Z가-힣]+-\\d+");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new InvalidOrderException();
        }
    }

    // 입력 날짜가 범위에서 벗어난 경우
    public static void validateInputDayNumber(int input){
        if(input < 0 || input > 31){
            throw new InvalidOrderException();
        }
    }
}
