package order.domain;

import static order.global.constant.ErrorMessage.INVALID_ORDER_MINIMUM_AMOUNT;

public class OrderResult {

    private static final int ORDER_MINIMUM_AMOUNT = 30_000;
    private static final int DELIVERY_FEE_THRESHOLD_1 = 50_000;
    private static final int DELIVERY_FEE_THRESHOLD_2 = 100_000;
    private static final int DELIVERY_FEE_1 = 2_000;
    private static final int DELIVERY_FEE_2 = 1_000;
    private static final int DELIVERY_FEE_FREE = 0;

    private final int totalAmount;
    private final int deliveryFee;

    public OrderResult(final int totalAmount) {
        validateAmount(totalAmount);
        this.totalAmount = totalAmount;
        this.deliveryFee = calculateDeliveryFee();
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public int calculateFinalAmount() {
        return totalAmount + deliveryFee;
    }

    private void validateAmount(final int amount) {
        if (amount < ORDER_MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(INVALID_ORDER_MINIMUM_AMOUNT.get());
        }
    }

    private int calculateDeliveryFee() {
        if (totalAmount < DELIVERY_FEE_THRESHOLD_1) {
            return DELIVERY_FEE_1;
        }
        if (totalAmount < DELIVERY_FEE_THRESHOLD_2) {
            return DELIVERY_FEE_2;
        }
        return DELIVERY_FEE_FREE;
    }
}
