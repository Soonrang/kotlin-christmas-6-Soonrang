package christmas.model;

import java.util.HashMap;
import java.util.Map;

import static christmas.validate.InputValidator.*;

public class Restuarant {

    private int totalPrice;
    private int day;
    private Map<String, Integer> order;
    private TotalMenu totalMenu;

    public Restuarant(int day, Map<String,Integer> order, TotalMenu totalMenu){
        this.order = new HashMap<>();
        this.totalMenu = totalMenu;
        this.day = day;
    }




    //public int getTotalDiscountPrice()
}
