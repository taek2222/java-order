package order.controller;

import java.util.List;
import order.domain.Order;
import order.domain.OrderResult;
import order.domain.Orders;
import order.domain.ServiceMenu;
import order.domain.dto.OrderResponse;
import order.domain.dto.ServiceResponse;
import order.global.util.OrderInputParser;
import order.view.InputView;
import order.view.OutputView;

public class OrderController {
    private final InputView inputView;
    private final OutputView outputView;

    public OrderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Orders orders = generateOrders();
        OrderResult orderResult = generateOrderResult(orders);
        ServiceMenu serviceMenu = generateServiceMenu(orders);

        displayOrderSummary(orders, orderResult, serviceMenu);

        inputView.closeScanner();
    }

    private void displayOrderSummary(Orders orders, OrderResult orderResult, ServiceMenu serviceMenu) {
        displayOrderDetails(orders);
        displayTotalAmount(orderResult);
        displayDeliveryFee(orderResult);
        displayServiceMenu(serviceMenu);
        displayFinalAmount(orderResult);
    }

    private void displayFinalAmount(OrderResult orderResult) {
        int finalAmount = orderResult.calculateFinalAmount();
        outputView.printFinalAmount(finalAmount);
    }

    private void displayServiceMenu(ServiceMenu orderService) {
        ServiceResponse response = orderService.createResponse();

        if (orderService.hasServiceQuantity()) {
            outputView.printServiceMenu(response);
        }
    }

    private void displayDeliveryFee(OrderResult orderResult) {
        int deliveryFee = orderResult.getDeliveryFee();
        outputView.printDeliveryFee(deliveryFee);
    }

    private void displayTotalAmount(OrderResult orderResult) {
        int totalAmount = orderResult.getTotalAmount();
        outputView.printTotalAmount(totalAmount);
    }

    private void displayOrderDetails(Orders orders) {
        List<OrderResponse> responses = orders.toOrderResponses();
        outputView.printOrderDetails(responses);
    }

    private ServiceMenu generateServiceMenu(Orders orders) {
        int quantity = orders.getTotalMainMenuQuantity();
        return new ServiceMenu(quantity);
    }

    private OrderResult generateOrderResult(Orders orders) {
        int totalAmount = orders.getTotalAmount();
        return new OrderResult(totalAmount);
    }

    private Orders generateOrders() {
        String orderInput = inputView.readOrderMenu();
        List<Order> parsedOrders = OrderInputParser.parseOrderInput(orderInput);

        return new Orders(parsedOrders);
    }
}
