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
import java.util.List;

public class OrderService {
    private final OrderValidator orderValidator;
    private final OrderFactory orderFactory;

    public OrderService(OrderValidator orderValidator, OrderFactory orderFactory) {
        this.orderValidator = orderValidator;
        this.orderFactory = orderFactory;
    }

    public OrderResponseDTO getOrderResponseDTO(List<OrderRequestDTO> orderRequestDTOS) {
        List<Order> orders = orderFactory.createOrdersByOrderDTOS(orderRequestDTOS);

        int ordersPrice = calculateOrdersPrice(orders);
        validateOrders(orders, ordersPrice);
        int deliveryFee = DeliveryFee.getDeliveryFee(ordersPrice);
        int countMainTypeProduct = countMainTypeProducts(orders);
        int orderTotalPrice = ordersPrice + deliveryFee;

        List<OrderProductResponseDTO> orderProductResponseDTOList = createOrderProductResponseDTOS(orders);

        return new OrderResponseDTO(
                orderProductResponseDTOList,
                ordersPrice,
                deliveryFee,
                createOrderServiceResponseDTO(countMainTypeProduct),
                orderTotalPrice
        );
    }

    private List<OrderProductResponseDTO> createOrderProductResponseDTOS(List<Order> orders) {
        List<OrderProductResponseDTO> orderProductResponseDTOList = new ArrayList<>();
        for (Order order : orders) {
            int price = order.getOrderPrice();
            orderProductResponseDTOList.add(new OrderProductResponseDTO(
                    order.getProduct().getName(),
                    order.getQuantity(),
                    price
            ));
        }
        return orderProductResponseDTOList;
    }

    private int countMainTypeProducts(List<Order> orders) {
        return orders.stream()
                .filter(this::isProductTypeMain)
                .mapToInt(Order::getQuantity)
                .sum();
    }

    private Integer calculateOrdersPrice(List<Order> orders) {
        return orders.stream().mapToInt(Order::getOrderPrice).sum();
    }

    private void validateOrders(List<Order> orders, Integer ordersPrice) {
        orderValidator.validateOnlyDrinks(orders);
        orderValidator.validateMinimumPrice(ordersPrice);
        orders.forEach(orderValidator::validateProductQuantity);
    }

    private boolean isProductTypeMain(Order order) {
        return order.getProduct().getType() == ProductType.MAIN;
    }

    private OrderServiceResponseDTO createOrderServiceResponseDTO(Integer countMainTypeProduct) {
        if (countMainTypeProduct == 0)
            return null;

        return new OrderServiceResponseDTO(
                Product.DUMPLING.getName(),
                countMainTypeProduct
        );
    }
}
