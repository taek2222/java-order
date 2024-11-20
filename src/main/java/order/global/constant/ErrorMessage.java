package order.global.constant;

public enum ErrorMessage {
    INVALID_ORDER_QUANTITY("주문 메뉴의 수량은 최대 %d 까지만 가능 합니다."),
    INVALID_ORDER_FORMAT("주문 형식이 잘못되었습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return ERROR_PREFIX + message;
    }

    public String get(Object... value) {
        return ERROR_PREFIX + String.format(message, value);
    }
}