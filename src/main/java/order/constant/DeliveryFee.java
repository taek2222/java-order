package order.constant;

public enum DeliveryFee {
    DELIVERY_FEE_LEVEL_1(2000),
    DELIVERY_FEE_LEVEL_2(1000),
    DELIVERY_FEE_LEVEL_3(0);

    private final int deliveryFee;

    DeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public static int getDeliveryFee(int orderTotalPrice) {
        if (orderTotalPrice < 50000)
            return DELIVERY_FEE_LEVEL_1.deliveryFee;
        if (orderTotalPrice < 100000)
            return DELIVERY_FEE_LEVEL_2.deliveryFee;

        return DELIVERY_FEE_LEVEL_3.deliveryFee;
    }
}
