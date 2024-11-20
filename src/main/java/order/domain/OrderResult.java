package order.domain;

import static order.global.constant.ErrorMessage.INVALID_ORDER_MINIMUM_AMOUNT;

public class OrderResult {

    private static final int ORDER_MINIMUM_AMOUNT = 30000;

    private final int amount;

    public OrderResult(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < ORDER_MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(INVALID_ORDER_MINIMUM_AMOUNT.get());
        }
    }
}
