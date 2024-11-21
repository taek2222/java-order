package order.global.constant;

public enum ErrorMessage {
    INVALID_ORDER_MINIMUM_AMOUNT("최소 주문 금액을 만족하지 못했습니다."),
    INVALID_ORDER_ONLY_DRINK("음료만으로는 주문할 수 없습니다."),
    INVALID_ORDERS_MINIMUM("주문 수는 최소 %d 이상이어야만 가능합니다."),
    INVALID_ORDER_QUANTITY("주문 메뉴의 수량은 최대 %d 까지만 가능 합니다."),
    INVALID_ORDER_FORMAT("주문 형식이 잘못되었습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String get() {
        return ERROR_PREFIX + message;
    }

    public String get(Object... value) {
        return ERROR_PREFIX + String.format(message, value);
    }
}