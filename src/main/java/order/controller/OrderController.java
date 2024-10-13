package order.controller;

import order.dto.OrderRequestDTO;
import order.dto.OrderResponseDTO;
import order.service.OrderService;
import order.validation.OrderValidator;
import order.view.InputView;
import order.view.OrderView;
import order.view.OutputView;

import java.util.List;

import static order.util.ProductConverter.*;

public class OrderController {
    public static final String START_MESSAGE = "주문하실 메뉴와 수량을 입력해주세요. ex) 피자(2개), 감자튀김(1개), 콜라(3개)";

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    OrderValidator orderValidator = new OrderValidator();
    OrderService orderService = new OrderService(orderValidator);
    OrderView orderView = new OrderView(outputView);

    public void run() {
        orderStart();
        String input = inputView.input();

        List<OrderRequestDTO> products = convertInputToProductDTOS(input);

        OrderResponseDTO orderResponseDTO = orderService.getOrderResponseDTO(products);

        orderView.printOrderResponse(orderResponseDTO);
    }

    private void orderStart() {
        outputView.printlnMessage(START_MESSAGE);
    }
}
