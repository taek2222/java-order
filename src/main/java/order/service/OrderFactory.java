package order.service;

import order.constant.Product;
import order.domain.Order;
import order.dto.OrderRequestDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderFactory {

    public List<Order> createOrdersByOrderDTOS(List<OrderRequestDTO> orderRequestDTOS) {
        List<Order> orders = new ArrayList<>();
        for (OrderRequestDTO orderRequestDTO : orderRequestDTOS) {
            Product product = findProduct(orderRequestDTO.productName());
            Order order = new Order(product, orderRequestDTO.quantity());
            orders.add(order);
        }
        return orders;
    }

    private Product findProduct(String productName) {
        return Arrays.stream(Product.values())
                .filter(product -> product.getName().equals(productName))
                .findFirst()
                .orElseThrow();
    }
}
