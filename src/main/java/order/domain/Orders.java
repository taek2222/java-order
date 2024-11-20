package order.domain;

import static order.global.validate.OrdersValidator.validateOrders;

import java.util.List;

public class Orders {

    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validateOrders(orders);
        this.orders = orders;
    }

    public int calculateCountMainMenu() {
        return (int) orders.stream()
                .filter(Order::isMainMenu)
                .count();
    }

    public int calculateTotalPrice() {
        return orders.stream()
                .mapToInt(Order::calculatePrice)
                .sum();
    }
}
