package order.domain;

import static order.global.validate.OrdersValidator.validateOrders;

import java.util.List;
import order.domain.dto.OrderResponse;

public class Orders {

    private final List<Order> orders;

    public Orders(final List<Order> orders) {
        validateOrders(orders);
        this.orders = orders;
    }

    public int getTotalMainMenuQuantity() {
        return orders.stream()
                .mapToInt(Order::getQuantityIfMainMenu)
                .sum();
    }

    public int getTotalAmount() {
        return orders.stream()
                .mapToInt(Order::calculateAmount)
                .sum();
    }

    public List<OrderResponse> toOrderResponses() {
        return orders.stream()
                .map(Order::createResponse)
                .toList();
    }
}
