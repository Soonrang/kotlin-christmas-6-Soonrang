package christmas.model;

import static christmas.validate.InputValidator.validateOnlyNumber;

public class VisitDay {

    private final int day;

    public VisitDay(int day) {
        this.day = day;
    }

    public static VisitDay create(int day){
        validateOnlyNumber(day);
        return new VisitDay(day);
    }

}
