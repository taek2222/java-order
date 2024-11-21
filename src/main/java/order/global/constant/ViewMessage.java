package order.global.constant;

public enum ViewMessage {
    // Input Message
    INPUT_ORDER_MENU_MESSAGE("주문하실 메뉴와 수량을 입력해주세요. ex) 피자(2개), 감자튀김(1개), 콜라(3개)"),

    // Output Message
    OUTPUT_ORDER_INFO_HEADER("[주문 내역]"),
    OUTPUT_TOTAL_AMOUNT_MESSAGE("총 주문 금액: %s원"),
    OUTPUT_DELIVERY_FEE_MESSAGE("배달비: %s원"),
    OUTPUT_SERVICE_MENU_HEADER("[서비스]"),
    OUTPUT_SERVICE_MENU_MESSAGE("서비스 만두(%d개)"),
    OUTPUT_FINAL_RESULT_PRICE_HEADER("[최종 결제 금액]"),
    OUTPUT_FINAL_RESULT_PRICE_MESSAGE("%s원"),
    OUTPUT_ORDER_INFO_FORMAT("%s(%d개): %s원"),

    NEW_LINE(System.lineSeparator());

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public String get(Object... value) {
        return String.format(message, value);
    }
}
