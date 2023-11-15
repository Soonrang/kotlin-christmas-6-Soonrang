package christmas.exception;

public class Quantity20Exception extends IllegalArgumentException{

    public static final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public Quantity20Exception(){
        super(ERROR_MESSAGE);
    }
}
