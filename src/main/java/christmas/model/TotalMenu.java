package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class TotalMenu {

    private final Map<String, Integer> appetizer = new HashMap<>();
    private final Map<String, Integer> mainMenu = new HashMap<>();
    private final Map<String, Integer> dessert = new HashMap<>();
    private final Map<String, Integer> drink = new HashMap<>();

    public TotalMenu() {
        appetizerSetting();
        mainMenuSetting();
        dessertSetting();
        drinkSetting();
    }

    private void appetizerSetting(){
        appetizer.put("양송이수프",6000);
        appetizer.put("타파스",5500);
        appetizer.put("시저샐러드",8000);
    }

    private void mainMenuSetting() {
        mainMenu.put("티본스테이크",55000);
        mainMenu.put("바비큐립",54000);
        mainMenu.put("해산물파스타",35000);
        mainMenu.put("크리스마스파스타",25000);
    }

    private void dessertSetting(){
        dessert.put("초코케이크",15000);
        dessert.put("아이스크림",5000);
    }

    private void drinkSetting(){
        drink.put("제로콜라",3000);
        drink.put("레드와인",60000);
        drink.put("샴페인",25000);
    }

    // 새로운 메서드: 모든 메뉴의 Map을 하나로 합치기
    public Map<String, Integer> combineAllMenus() {
        Map<String, Integer> allMenus = new HashMap<>();

        // 애피타이저 메뉴 합치기
        allMenus.putAll(appetizer);

        // 메인 메뉴 합치기
        allMenus.putAll(mainMenu);

        // 디저트 메뉴 합치기
        allMenus.putAll(dessert);

        // 음료 메뉴 합치기
        allMenus.putAll(drink);

        return allMenus;
    }

    public Map<String, Integer> getAppetizer() {
        return new HashMap<>(appetizer);
    }

    public Map<String, Integer> getMainMenu() {
        return new HashMap<>(mainMenu);
    }

    public Map<String, Integer> getDessert() {
        return new HashMap<>(dessert);
    }

    public Map<String, Integer> getDrink() {
        return new HashMap<>(drink);
    }

    public Map<String, Integer> getAllMenus() {
        return new HashMap<>(combineAllMenus());
    }



}
