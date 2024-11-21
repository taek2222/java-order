package order.domain;

import static order.global.validate.OrdersValidator.validateOrders;

import java.util.List;
import order.domain.dto.OrderResponse;

public class Orders {

    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validateOrders(orders);
        this.orders = orders;
    }

    public int calculateCountMainMenu() {
        return orders.stream()
                .mapToInt(Order::getQuantityIfMainMenu)
                .sum();
    }

    public int calculateTotalPrice() {
        return orders.stream()
                .mapToInt(Order::calculatePrice)
                .sum();
    }

    public List<OrderResponse> createOrderResponses() {
        return orders.stream()
                .map(Order::createOrderResponse)
                .toList();
    }
}
