package order.global.constant;

public enum ErrorMessage {
    INVALID_ORDER_FORMAT("주문 형식이 잘못되었습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}