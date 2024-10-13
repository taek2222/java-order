package order.controller;

import order.dto.OrderRequestDTO;
import order.dto.OrderResponseDTO;
import order.service.OrderFactory;
import order.service.OrderService;
import order.util.ProductConverter;
import order.validation.OrderValidator;
import order.view.InputView;
import order.view.OrderView;
import order.view.OutputView;

import java.util.List;

public class OrderController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    OrderView orderView = new OrderView(outputView);

    ProductConverter productConverter = new ProductConverter();
    OrderValidator orderValidator = new OrderValidator();

    OrderFactory orderFactory = new OrderFactory();
    OrderService orderService = new OrderService(orderValidator, orderFactory);

    public void run() {
        orderView.orderStart();
        String input = inputView.input();

        List<OrderRequestDTO> products = productConverter.convertInputToProductDTOS(input);
        OrderResponseDTO orderResponseDTO = orderService.getOrderResponseDTO(products);

        orderView.printOrderResponse(orderResponseDTO);
    }
}
