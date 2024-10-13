package order.view;

import order.dto.OrderProductResponseDTO;
import order.dto.OrderResponseDTO;

import java.text.DecimalFormat;

public class OrderView {
    private final OutputView outputView;

    public OrderView(OutputView outputView) {
        this.outputView = outputView;
    }

    public void printOrderResponse(OrderResponseDTO orderResponseDTO) {
        DecimalFormat df = new DecimalFormat("#,###");

        outputView.printLineMessage("[주문 내역]");

        for (OrderProductResponseDTO orderProductResponseDTO : orderResponseDTO.orderProductResponseDTOS()) {
            outputView.printMessage(orderProductResponseDTO.product());
            outputView.printMessage("(" + orderProductResponseDTO.quantity() + "개): ");
            outputView.printlnMessage(df.format(orderProductResponseDTO.price()) + "원");
        }

        outputView.printlnMessage("총 주문 금액: " + df.format(orderResponseDTO.orderTotalPrice()) + "원");
        outputView.printlnMessage("배달비: " + orderResponseDTO.delivery() + "원");

        if (orderResponseDTO.orderServiceResponseDTO() != null) {
            outputView.printLineMessage("[서비스]");
            outputView.printMessage(orderResponseDTO.orderServiceResponseDTO().product());
            outputView.printlnMessage("(" + orderResponseDTO.orderServiceResponseDTO().quantity() + "개)");
        }

        outputView.printLineMessage("[최종 결제 금액]");
        outputView.printlnMessage(df.format(orderResponseDTO.orderTotalPrice() + orderResponseDTO.delivery()) + "원");
    }
}
