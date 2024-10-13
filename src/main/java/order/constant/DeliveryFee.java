package order.constant;

public enum DeliveryFee {
    LEVEL_1(2000),
    LEVEL_2(1000),
    LEVEL_3(0);

    public static final int LEVEL_1_THRESHOLD = 50000;
    public static final int LEVEL_2_THRESHOLD = 100000;
    private final int fee;

    DeliveryFee(int deliveryFee) {
        this.fee = deliveryFee;
    }

    public static int getDeliveryFee(int ordersPrice) {
        if (isLEVEL1(ordersPrice))
            return LEVEL_1.fee;
        if (isLEVEL2(ordersPrice))
            return LEVEL_2.fee;

        return LEVEL_3.fee;
    }

    private static boolean isLEVEL1(int ordersPrice) {
        return ordersPrice < LEVEL_1_THRESHOLD;
    }

    private static boolean isLEVEL2(int ordersPrice) {
        return ordersPrice < LEVEL_2_THRESHOLD;
    }
}