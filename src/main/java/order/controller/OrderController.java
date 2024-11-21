package order.controller;

import java.util.List;
import order.domain.Order;
import order.domain.OrderResult;
import order.domain.OrderService;
import order.domain.Orders;
import order.domain.dto.OrderResponse;
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
        String orderInput = inputView.readOrderMenu();
        List<Order> parsedOrders = OrderInputParser.parseOrderInput(orderInput);
        Orders orders = new Orders(parsedOrders);

        int amount = orders.calculateTotalPrice();
        OrderResult orderResult = new OrderResult(amount);

        int count = orders.calculateCountMainMenu();
        OrderService orderService = new OrderService(count);

        List<OrderResponse> responses = orders.createOrderResponses();
        outputView.printOrdersInfo(responses);

        int resultAmount = orderResult.getAmount();
        outputView.printAmount(resultAmount);

        int deliveryFee = orderResult.getDeliveryFee();
        outputView.printDeliveryFee(deliveryFee);

        int serviceDumpling = orderService.getServiceDumpling();
        outputView.printServiceMenu(serviceDumpling);

        int finalAmount = orderResult.calculateFinalAmount();
        outputView.printFinalResultPrice(finalAmount);
    }
}
