package christmas.controller;

import christmas.exception.NonNumericInputException;
import christmas.model.PresentEvent;
import christmas.model.Restuarant;
import christmas.model.TotalMenu;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

import static christmas.model.DiscountEvent.*;
import static christmas.model.Order.makeOrderList;
import static christmas.model.Order.validateNoneMenu;

public class RestaurantController {

    private InputView inputView;
    private OutputView outputView;

    public RestaurantController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void Order() {
        int day = inputUserVisitDay();
        Map<String, Integer> orderMenu = inputUserOrderMenu();
        TotalMenu totalMenu = new TotalMenu();
        Map<String,Integer> menuList = totalMenu.getAllMenus();
        //System.out.println(menuList);
        outputView.printBenefitDay(day);
        outputView.printOrderMenu(orderMenu);
        int beforeDiscount = calculateAllprice(orderMenu,menuList);
        outputView.printBeforeDiscount(beforeDiscount);
        outputView.printPresent(presentChampagne(beforeDiscount));
        int totalDiscount = discountDdayEvent(day) + weekendEvent(day,orderMenu) + discountHasStar(day+presentChampangePrice(presentChampagne(beforeDiscount)));
        outputView.printBenefitList(beforeDiscount,discountDdayEvent(day),weekendEvent(day,orderMenu),discountHasStar(day),presentChampangePrice(presentChampagne(beforeDiscount)));
        outputView.printExceptionPrice(beforeDiscount,totalDiscount,presentChampangePrice(presentChampagne(beforeDiscount)));
        outputView.printBadge(totalDiscount);
    }

    private int inputUserVisitDay() {
        while (true) {
            try {
                int userInputDay = Integer.parseInt(inputView.inputVisitDay());
                return userInputDay;
            } catch (NonNumericInputException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<String,Integer> inputUserOrderMenu(){
        TotalMenu totalMenu = new TotalMenu();
        while (true) {
            try {
                String inputOrder = inputView.inputOrderMenu();
                Map<String,Integer> menuList = totalMenu.getAllMenus();
                Map<String,Integer> orderList = makeOrderList(inputOrder);
                validateNoneMenu(orderList,menuList);
                return makeOrderList(inputOrder);
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            } catch (IllegalStateException e){
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private int calculateAllprice(Map<String, Integer> order, Map<String, Integer> menu){
        int total = 0;

        for(Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String menuName = orderEntry.getKey();
            int orderQuantity = orderEntry.getValue();

            if(menu.containsKey(menuName)){
                int menuPrice = menu.get(menuName);
                total += orderQuantity *menuPrice;
            }
        }
        return total;
    }

    private boolean presentChampagne(int beforeDiscount) {
        PresentEvent presentEvent = new PresentEvent(beforeDiscount);
        return presentEvent.isPresentChampagne();
    }
    private int presentChampangePrice(boolean presentChampagne){
        if(presentChampagne){
            return 25000;
        } return 0;
    }


    private int weekendEvent(int day, Map<String, Integer> orderList){
        TotalMenu totalMenu = new TotalMenu();
        Map<String,Integer> dessert = totalMenu.getDessert();
        Map<String,Integer> mainMenu = totalMenu.getMainMenu();
        int totalDiscount = 0;
        if(isWeekend(day)){
            totalDiscount = weekendDiscountEvent(orderList,mainMenu);
        } else if(isWeekend(day)==false){
            totalDiscount = weekendDiscountEvent(orderList,dessert);
        }
        return totalDiscount;
    }


}
