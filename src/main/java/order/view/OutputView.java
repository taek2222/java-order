package order.view;

import java.text.DecimalFormat;
import java.util.List;
import order.domain.dto.OrderResponse;

public class OutputView {

    private static final DecimalFormat PRICE_FORMAT = new DecimalFormat("###,###");

    public void printOrdersInfo(List<OrderResponse> orderResponses) {
        System.out.println();
        System.out.println("[주문 내역]");
        orderResponses.forEach(this::printOrderInfo);
    }

    public void printAmount(int amount) {
        String format = PRICE_FORMAT.format(amount);
        System.out.printf("총 주문 금액: %s원", format);
        System.out.println();
    }

    public void printDeliveryFee(int deliveryFee) {
        String format = PRICE_FORMAT.format(deliveryFee);
        System.out.printf("배달비: %s원", format);
        System.out.println();
    }

    public void printServiceMenu(int quantity) {
        System.out.println();
        System.out.println("[서비스]");
        System.out.printf("서비스 만두(%d개)", quantity);
        System.out.println();
    }

    public void printFinalResultPrice(int price) {
        System.out.println();
        String format = PRICE_FORMAT.format(price);
        System.out.println("[최종 결제 금액]");
        System.out.printf("%s원", format);
    }

    private void printOrderInfo(OrderResponse orderResponse) {
        String price = PRICE_FORMAT.format(orderResponse.price());
        String format = "%s(%d개): %s원";

        System.out.printf(format, orderResponse.menuName(), orderResponse.quantity(), price);
        System.out.println();
    }
}
