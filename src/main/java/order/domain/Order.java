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
        validateQuantity(quantity);
        this.menu = menu;
        this.quantity = quantity;
    }

    public int calculateAmount() {
        return menu.getPrice() * quantity;
    }

    public boolean isDrink() {
        return menu.getMenuType() == DRINK;
    }

    public int getQuantityIfMainMenu() {
        if (menu.getMenuType() == MAIN) {
            return quantity;
        }
        return 0;
    }

    public OrderResponse createResponse() {
        return new OrderResponse(
                menu.getName(),
                quantity,
                calculateAmount()
        );
    }

    private void validateQuantity(int quantity) {
        if (quantity > MAXIMUM_QUANTITY) {
            throw new IllegalArgumentException(INVALID_ORDER_QUANTITY.get(MAXIMUM_QUANTITY));
        }
    }
}
