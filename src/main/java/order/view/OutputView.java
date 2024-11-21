package order.view;

import static order.global.constant.ViewMessage.NEW_LINE;
import static order.global.constant.ViewMessage.OUTPUT_DELIVERY_FEE_MESSAGE;
import static order.global.constant.ViewMessage.OUTPUT_FINAL_AMOUNT_HEADER;
import static order.global.constant.ViewMessage.OUTPUT_FINAL_AMOUNT_MESSAGE;
import static order.global.constant.ViewMessage.OUTPUT_ORDER_DETAILS_HEADER;
import static order.global.constant.ViewMessage.OUTPUT_ORDER_DETAIL_FORMAT;
import static order.global.constant.ViewMessage.OUTPUT_SERVICE_MENU_HEADER;
import static order.global.constant.ViewMessage.OUTPUT_SERVICE_MENU_MESSAGE;
import static order.global.constant.ViewMessage.OUTPUT_TOTAL_AMOUNT_MESSAGE;

import java.text.DecimalFormat;
import java.util.List;
import order.domain.dto.OrderResponse;

public class OutputView {

    private static final DecimalFormat PRICE_FORMAT = new DecimalFormat("###,###");

    public void printOrderDetails(List<OrderResponse> orderResponses) {
        newLine();
        System.out.println(OUTPUT_ORDER_DETAILS_HEADER.get());
        orderResponses.forEach(this::printSingleOrderDetail);
    }

    public void printTotalAmount(int amount) {
        System.out.printf(OUTPUT_TOTAL_AMOUNT_MESSAGE.get(formatPrice(amount)));
        newLine();
    }

    public void printDeliveryFee(int deliveryFee) {
        System.out.printf(OUTPUT_DELIVERY_FEE_MESSAGE.get(formatPrice(deliveryFee)));
        newLine();
    }

    public void printServiceMenu(int quantity) {
        newLine();
        System.out.println(OUTPUT_SERVICE_MENU_HEADER.get());
        System.out.printf(OUTPUT_SERVICE_MENU_MESSAGE.get(quantity));
        newLine();
    }

    public void printFinalAmount(int amount) {
        newLine();
        System.out.println(OUTPUT_FINAL_AMOUNT_HEADER.get());
        System.out.printf(OUTPUT_FINAL_AMOUNT_MESSAGE.get(formatPrice(amount)));
    }

    private void printSingleOrderDetail(OrderResponse orderResponse) {
        System.out.printf(OUTPUT_ORDER_DETAIL_FORMAT.get(
                orderResponse.menuName(),
                orderResponse.quantity(),
                formatPrice(orderResponse.price())
        ));

        newLine();
    }

    private static String formatPrice(int price) {
        return PRICE_FORMAT.format(price);
    }

    private void newLine() {
        System.out.print(NEW_LINE.get());
    }
}
