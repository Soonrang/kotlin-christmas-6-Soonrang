package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DiscountEvent {

    private static final int EVENT_YEAR = 2023;
    private static final int EVENT_MONTH = 12;
    private static final int D_DAY_EVENT_DISCOUNT = 1000;
    private static final int D_DAY_EVENT_INCREASE = 100;
    private static final int DECEMBER_EVENT_DISCOUNT = 2023;
    private static final int BADGE_EVENT_DISCOUNT = 1000;

    public static int weekendDiscountEvent(Map<String, Integer> orderList, Map<String, Integer> eventMenu) {
        int totalDiscount = 0;

        for (Map.Entry<String, Integer> orderEntry : orderList.entrySet()) {
            String menuName = orderEntry.getKey();
            int orderQuantity = orderEntry.getValue();

            if (eventMenu.containsKey(menuName)) {
                totalDiscount += orderQuantity * DECEMBER_EVENT_DISCOUNT;
            }
        }

        return totalDiscount;
    }

    public static int discountHasStar(int day) {
        if (day == 3 || day == 10 || day == 17 || day == 24 || day == 25 || day == 31) {
            return 1000;
        }
        return 0;
    }


    public static int discountDdayEvent(int day) {
        int discount = 0;
        if (day > 0 && day < 26) {
            discount = D_DAY_EVENT_DISCOUNT + (day - 1) * D_DAY_EVENT_INCREASE;
        }
        return discount;
    }

    public static boolean isWeekend(int day) {
        LocalDate date = LocalDate.of(EVENT_YEAR, EVENT_MONTH, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

}

//package christmas.model;
//
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class DiscountEvent {
//
//    private static final int EVENT_PRICE_CRITERIA = 10000;
//    private static final int ORDER_AMOUNT_MAX = 20;
//    private static final int EVENT_YEAR = 2023;
//    private static final int EVENT_MONTH = 12;
//    private static final int D_DAY_EVENT_DISCOUNT = 1000;
//    private static final int D_DAY_EVENT_INCREASE = 100;
//    private static final int DECEMBER_EVENT_DISCOUNT = 2023;
//    private static final int BADGE_EVENT_DISCOUNT = 1000;
//
//
//    public int weekendDiscountEvent(Map<String, Integer> orderList, Map<String, Integer> eventMenu) {
//        int totalDiscount = 0;
//
//        for (Map.Entry<String, Integer> orderEntry : orderList.entrySet()) {
//            String menuName = orderEntry.getKey();
//            int orderQuantity = orderEntry.getValue();
//
//            if (eventMenu.containsKey(menuName)) {
//                int menuPrice = eventMenu.get(menuName);
//                int discountAmount = orderQuantity * DECEMBER_EVENT_DISCOUNT;
//
//                totalDiscount += discountAmount;
//            }
//        }
//
//        return totalDiscount;
//    }
//
//    public int discountHasStar(List<String> badgeList, int totalPrice){
//
//       if(badgeList.contains("star")){
//           return totalPrice - BADGE_EVENT_DISCOUNT;
//
//       } return totalPrice;
//
//    }
//
//    public int discountDdayEvent( int day , int totalPrice ){
//        int discount = 0;
//
//        if(day>0 && day<26){
//            discount = D_DAY_EVENT_DISCOUNT + (day-1) * D_DAY_EVENT_INCREASE;
//        }
//
//        return totalPrice - discount;
//    }
//
//    public boolean isWeekend(int day) {
//        LocalDate date = LocalDate.of(EVENT_YEAR,EVENT_MONTH,day);
//        DayOfWeek dayOfWeek = date.getDayOfWeek();
//        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
//    }
//
//    public String findDesert(Map<String,String> orderList, Map<String,String> desert){
//        if(orderList.containsKey(desert.keySet())){
//
//        }
//    }
//
//}
