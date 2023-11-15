package christmas.util;

public class NumberFormatter extends Throwable {
    public static String formatWithCommas(int number) {
        return String.format("%,d", number);
    }
}
