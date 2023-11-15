package christmas.model;

import christmas.exception.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {

    private Map<String,Integer> orderList = new HashMap<>();

    public Order(Map<String,Integer> orderList){
        validateZero(orderList);
        this.orderList = orderList;
    }

    public static Map<String,Integer> makeOrderList (String input){
        String[] menuOrder = input.split(",");
        Map<String,Integer> orderList = new HashMap<>();

        for (String menuItem : menuOrder){
            String[] parts = menuItem.split("-");
            String menuName = parts[0].trim();
            int quantity = Integer.parseInt(parts[1].trim());
            orderList.put(menuName,quantity);
        }

        validateQuantityZero(orderList);
        validateDuplicateMenu(orderList);
        validateQuantity20(orderList);
        validateZero(orderList);

        return orderList;
    }

    // 메뉴를 주문하지 않은 경우
    private static void validateZero(Map<String, Integer> orderList){
        if(orderList.isEmpty()){
            throw new ZeroMenuException();
        }
    }

    // 수량 0 체크
    private static void validateQuantityZero(Map<String, Integer> inputMenu){
        if(inputMenu.containsValue(0)){
            throw new ZeroMenuException();
        }
    }

    // 중복메뉴체크
    private static void validateDuplicateMenu(Map<String, Integer> inputMenu){
        Set temp = inputMenu.entrySet();
        if(temp.size() != inputMenu.size()){
            throw new DuplicateMenuException();
        }
    }

    // 음료만 주문한 경우
    private void validateOnlyDrink(Map<String, Integer> inputMenu, Map<String, Integer> drink) {
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
    private static void validateQuantity20(Map<String, Integer> inputMenu){
        int orderAmount = 0;
        for (Integer quantity : inputMenu.values()) {
            if (quantity != null) {
                orderAmount += quantity;
            }
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


}