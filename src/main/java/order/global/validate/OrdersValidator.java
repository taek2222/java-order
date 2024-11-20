package order.global.validate;

import static order.global.constant.ErrorMessage.INVALID_ORDERS_MINIMUM;
import static order.global.constant.ErrorMessage.INVALID_ORDER_ONLY_DRINK;

import java.util.List;
import order.domain.Order;

public class OrdersValidator {

    private static final int ORDERS_MINIMUM = 1;

    public static void validateOrders(List<Order> orders) {
        validateOrdersMinimum(orders);
        validateOnlyMenuTypeDrink(orders);
    }

    private static void validateOrdersMinimum(List<Order> orders) {
        if (orders.size() < ORDERS_MINIMUM) {
            throw new IllegalArgumentException(INVALID_ORDERS_MINIMUM.get());
        }
    }

    private static void validateOnlyMenuTypeDrink(List<Order> orders) {
        boolean hasNonDrink = orders.stream()
                .anyMatch(order -> !order.isDrinkMenu());

        if (!hasNonDrink) {
            throw new IllegalArgumentException(INVALID_ORDER_ONLY_DRINK.get());
        }
    }
}
