package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.validate.InputValidator.*;

public class InputView {

    private final String INPUT_VISIT_DAY_MESSAGE ="안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."+
                                            "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private final String INPUT_MENU_QUANTITY_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";


    public String inputVisitDay(){
        System.out.println(INPUT_VISIT_DAY_MESSAGE);
        String inputVisitDay = Console.readLine();
        validateInputBlank(inputVisitDay);
        validateOnlyNumber(Integer.parseInt(inputVisitDay));
        validateInputDayNumber(Integer.parseInt(inputVisitDay));
        return inputVisitDay;
    }

    public String inputOrderMenu(){
        System.out.println(INPUT_MENU_QUANTITY_MESSAGE);
        String orderMenu = Console.readLine();
        validateInputBlank(orderMenu);
        //validateInputPattern(orderMenu);
        return orderMenu;
    }


}
