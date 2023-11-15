package christmas.view;

import java.util.Map;

import static christmas.model.Badge.presentBadge;
import static christmas.util.NumberFormatter.formatWithCommas;

public class OutputView {

    private final String OUTPUT_EVENT_INFORMATION = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final String OUTPUT_EVENT_DAY_INFORMATION = "우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final String OUTPUT_MENU_QUANTITY_MESSAGE = "<주문 메뉴>";
    private final String OUTPUT_BEFORE_DISCOUNT_MESSAGE = "<할인 전 총주문 금액>";
    private final String OUTPUT_PRESENT_MESSAGE = "<증정 메뉴>";
    private final String OUTPUT_NONE_MESSAGE = "없음";
    private final String OUTPUT_BENEFIT_LIST_MESSAGE = "<혜택 내역>";
    private final String OUTPUT_DISCOUNT_MESSAGE = "<총혜택 금액>";
    private final String OUTPUT_EXPECTATION_DISCOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private final String OUTPUT_BADGE_MESSAGE = "<12월 이벤트 배지>";
    private final String OUTPUT_BENEFIT1_MESSAGE = "크리스마스 디데이 할인: ";
    private final String OUTPUT_BENEFIT2_MESSAGE = "평일 할인: ";
    private final String OUTPUT_BENEFIT3_MESSAGE = "특별 할인: ";
    private final String OUTPUT_BENEFIT4_MESSAGE = "증정 이벤트: ";

    public void printOrderMenu(Map<String, Integer> userOrderMenu) {
        System.out.println();
        System.out.println(OUTPUT_MENU_QUANTITY_MESSAGE);

        for (Map.Entry<String, Integer> entry : userOrderMenu.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(menuName + " " + quantity + "개");
        }
    }

    public void printBeforeDiscount(int price){
        System.out.println();
        System.out.println(OUTPUT_BEFORE_DISCOUNT_MESSAGE);
        System.out.println(formatWithCommas(price)+"원");
    }

    public void printPresent(boolean presentChampagne){
        System.out.println();
        System.out.println(OUTPUT_PRESENT_MESSAGE);
        if(presentChampagne==true){
            System.out.println("샴페인 1개");
        } else if(presentChampagne==false){
            System.out.println(OUTPUT_NONE_MESSAGE);
        }
        System.out.println();
    }

    public void printBenefitList(int total ,int dDayDiscount, int weekendDiscount, int plusDiscount, int presentDiscount){
        System.out.println(OUTPUT_BENEFIT_LIST_MESSAGE);
        printBenefit(OUTPUT_BENEFIT1_MESSAGE,dDayDiscount);
        printBenefit(OUTPUT_BENEFIT2_MESSAGE,weekendDiscount);
        printBenefit(OUTPUT_BENEFIT3_MESSAGE,plusDiscount);
        printBenefit(OUTPUT_BENEFIT4_MESSAGE,presentDiscount);
    }

    private void printBenefit(String message, int price){
        if (price > 0) {
            System.out.println(message+"-"+formatWithCommas(price)+"원");
        }else if(price==0) {
            System.out.println(message+OUTPUT_NONE_MESSAGE);
        }
    }

//    public void printAllBenefit(int price ){
//        System.out.println();
//        System.out.println(OUTPUT_DISCOUNT_MESSAGE);
//        System.out.println("-"+formatWithCommas(price)+"원");
//    }

    public void printExceptionPrice(int total ,int totalDiscount, int presentDiscount){
        System.out.println();
        System.out.println(OUTPUT_DISCOUNT_MESSAGE);

        if(totalDiscount>0) {
            System.out.println("-" + formatWithCommas(totalDiscount) + "원");
        } else if (totalDiscount==0) {
            System.out.println(OUTPUT_NONE_MESSAGE);
        }

        System.out.println();
        System.out.println(OUTPUT_EXPECTATION_DISCOUNT_MESSAGE);
        System.out.println(formatWithCommas(total-totalDiscount+presentDiscount)+"원");
    }

    public void printBadge(int totalDiscount){
        System.out.println();
        System.out.println(OUTPUT_BADGE_MESSAGE);
        if(totalDiscount>=5000) {
            System.out.println(presentBadge(totalDiscount));
        }else if(totalDiscount<5000){
            System.out.println(OUTPUT_NONE_MESSAGE);
        }
    }

    public void printBenefitDay(int day){
        System.out.println("12월 "+day+"일에 "+ OUTPUT_EVENT_DAY_INFORMATION );
    }




}
