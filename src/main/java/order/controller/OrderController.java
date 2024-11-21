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
        String orderInput = inputView.readOrderMenu();
        List<Order> parsedOrders = OrderInputParser.parseOrderInput(orderInput);
        Orders orders = new Orders(parsedOrders);

        int amount = orders.getTotalAmount();
        OrderResult orderResult = new OrderResult(amount);

        int count = orders.getTotalMainMenuQuantity();
        ServiceMenu orderService = new ServiceMenu(count);

        List<OrderResponse> responses = orders.toOrderResponses();
        outputView.printOrderDetails(responses);

        int resultAmount = orderResult.getAmount();
        outputView.printTotalAmount(resultAmount);

        int deliveryFee = orderResult.getDeliveryFee();
        outputView.printDeliveryFee(deliveryFee);

        ServiceResponse response = orderService.createResponse();
        if (orderService.hasServiceQuantity()) {
            outputView.printServiceMenu(response);
        }

        int finalAmount = orderResult.calculateFinalAmount();
        outputView.printFinalAmount(finalAmount);

        inputView.closeScanner();
    }
}
