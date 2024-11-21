package order.domain;

import static order.domain.MenuType.DRINK;
import static order.domain.MenuType.MAIN;
import static order.global.constant.ErrorMessage.INVALID_ORDER_QUANTITY;

import order.domain.dto.OrderResponse;

public class Order {

    private static final int MAXIMUM_QUANTITY = 10;

    private final Menu menu;
    private final int quantity;

    public Order(Menu menu, int quantity) {
        validateMinimumQuantity(quantity);
        this.menu = menu;
        this.quantity = quantity;
    }

    public int calculatePrice() {
        return menu.getPrice() * quantity;
    }

    public boolean isDrinkMenu() {
        return menu.getMenuType() == DRINK;
    }

    public boolean isMainMenu() {
        return menu.getMenuType() == MAIN;
    }

    public OrderResponse createOrderResponse() {
        return new OrderResponse(
                menu.getName(),
                quantity,
                calculatePrice()
        );
    }

    private void validateMinimumQuantity(int quantity) {
        if (quantity > MAXIMUM_QUANTITY) {
            throw new IllegalArgumentException(INVALID_ORDER_QUANTITY.get(MAXIMUM_QUANTITY));
        }
    }
}
