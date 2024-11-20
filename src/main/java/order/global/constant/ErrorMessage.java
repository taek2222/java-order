package order.global.constant;

public enum ErrorMessage {
    INVALID_NUMERIC("주문 갯수는 숫자만 입력 가능합니다."),
    INVALID_ORDER_FORMAT("주문 형식이 잘못되었습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return ERROR_PREFIX + message;
    }
}