package order.service;

import order.constant.DeliveryFee;
import order.constant.Product;
import order.constant.ProductType;
import order.domain.Order;
import order.dto.OrderProductResponseDTO;
import order.dto.OrderRequestDTO;
import order.dto.OrderResponseDTO;
import order.dto.OrderServiceResponseDTO;
import order.validation.OrderValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderService {
    private final OrderValidator orderValidator;

    public OrderService(OrderValidator orderValidator) {
        this.orderValidator = orderValidator;
    }

    public OrderResponseDTO getOrderResponseDTO(List<OrderRequestDTO> orderRequestDTOS) {
        List<Order> orders = createOrdersByOrderDTOS(orderRequestDTOS);
        orderValidator.validateOnlyDrinks(orders);

        int orderTotalPrice = 0;
        int countMainTypeProduct = 0;

        List<OrderProductResponseDTO> orderProductResponseDTOList = new ArrayList<>();
        for (Order order : orders) {
            orderValidator.validateProductQuantity(order);

            if (order.getProduct().getType() == ProductType.MAIN)
                countMainTypeProduct++;

            int price = order.getOrderPrice();
            orderTotalPrice += price;
            orderProductResponseDTOList.add(createOrderProductResponseDTO(order, price));
        }
        orderValidator.validateMinimumPrice(orderTotalPrice);
        int deliveryFee = DeliveryFee.getDeliveryFee(orderTotalPrice);

        return new OrderResponseDTO(
                orderProductResponseDTOList,
                orderTotalPrice,
                deliveryFee,
                createOrderServiceResponseDTO(countMainTypeProduct)
                );
    }

    private OrderServiceResponseDTO createOrderServiceResponseDTO(Integer countMainTypeProduct) {
        if (countMainTypeProduct == 0)
            return null;

        return new OrderServiceResponseDTO(
                Product.DUMPLING.getName(),
                countMainTypeProduct
        );
    }

    private OrderProductResponseDTO createOrderProductResponseDTO(Order order, Integer price) {
        return new OrderProductResponseDTO(
                order.getProduct().getName(),
                order.getQuantity(),
                price
        );
    }

    private List<Order> createOrdersByOrderDTOS(List<OrderRequestDTO> orderRequestDTOS) {
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
