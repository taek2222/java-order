package order.domain;

import static order.global.constant.ErrorMessage.INVALID_ORDER_MINIMUM_AMOUNT;

public class OrderResult {

    private static final int ORDER_MINIMUM_AMOUNT = 30_000;

    private final int amount;
    private final int deliveryFee;

    public OrderResult(int amount) {
        validateAmount(amount);
        this.amount = amount;
        this.deliveryFee = calculateDeliveryFee();
    }

    public int getAmount() {
        return amount;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public int calculateFinalAmount() {
        return amount + deliveryFee;
    }

    private void validateAmount(int amount) {
        if (amount < ORDER_MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(INVALID_ORDER_MINIMUM_AMOUNT.get());
        }
    }

    private int calculateDeliveryFee() {
        if (amount < 50_000) {
            return 2_000;
        }
        if (amount < 100_000) {
            return 1_000;
        }
        return 0;
    }
}
