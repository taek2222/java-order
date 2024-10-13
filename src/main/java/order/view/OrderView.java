package order.view;

import order.dto.OrderProductResponseDTO;
import order.dto.OrderResponseDTO;

import java.text.DecimalFormat;

public class OrderView {
    private static final String START_MESSAGE = "주문하실 메뉴와 수량을 입력해주세요. ex) 피자(2개), 감자튀김(1개), 콜라(3개)";
    private final OutputView outputView;

    public OrderView(OutputView outputView) {
        this.outputView = outputView;
    }

    public void orderStart() {
        outputView.printlnMessage(START_MESSAGE);
    }

    public void printOrderResponse(OrderResponseDTO orderResponseDTO) {
        printTitle("주문 내역");
        for (OrderProductResponseDTO productResponseDTO : orderResponseDTO.orderProductResponseDTOS()) {
            printProduct(productResponseDTO.product(), productResponseDTO.quantity(), productResponseDTO.price());
        }
        printOrderContent("총 주문 금액", orderResponseDTO.ordersPrice());
        printOrderContent("배달비: ", orderResponseDTO.delivery());

        if (orderResponseDTO.orderServiceResponseDTO() != null) {
            printTitle("서비스");
            printProduct(orderResponseDTO.orderServiceResponseDTO().product(), orderResponseDTO.orderServiceResponseDTO().quantity());
            outputView.printlnMessage("");
        }

        printTitle("최종 결제 금액");
        printPrice(orderResponseDTO.orderTotalPrice());
    }

    private void printTitle(String title) {
        outputView.printLineMessage("[" + title + "]");
    }

    private void printPrice(Integer price) {
        DecimalFormat format = new DecimalFormat("#,###");
        outputView.printlnMessage(format.format(price) + "원");
    }

    private void printProduct(String product) {
        outputView.printMessage(product);
    }

    private void printProduct(String product, Integer quantity) {
        this.printProduct(product);
        outputView.printMessage("(" + quantity + "개)");
    }

    private void printProduct(String product, Integer quantity, Integer price) {
        this.printProduct(product, quantity);
        outputView.printMessage(": ");
        this.printPrice(price);
    }

    private void printOrderContent(String content, Integer price) {
        outputView.printMessage(content + ": ");
        printPrice(price);
    }
}
