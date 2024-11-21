package order.global.constant;

public enum ViewMessage {
    INPUT_ORDER_MENU_MESSAGE("주문하실 메뉴와 수량을 입력해주세요. ex) 피자(2개), 감자튀김(1개), 콜라(3개)");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
