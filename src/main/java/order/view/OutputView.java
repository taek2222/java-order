package order.view;

import static order.global.constant.ViewMessage.NEW_LINE;
import static order.global.constant.ViewMessage.OUTPUT_DELIVERY_FEE_MESSAGE;
import static order.global.constant.ViewMessage.OUTPUT_FINAL_RESULT_PRICE_HEADER;
import static order.global.constant.ViewMessage.OUTPUT_FINAL_RESULT_PRICE_MESSAGE;
import static order.global.constant.ViewMessage.OUTPUT_ORDER_INFO_FORMAT;
import static order.global.constant.ViewMessage.OUTPUT_ORDER_INFO_HEADER;
import static order.global.constant.ViewMessage.OUTPUT_SERVICE_MENU_HEADER;
import static order.global.constant.ViewMessage.OUTPUT_SERVICE_MENU_MESSAGE;
import static order.global.constant.ViewMessage.OUTPUT_TOTAL_AMOUNT_MESSAGE;

import java.text.DecimalFormat;
import java.util.List;
import order.domain.dto.OrderResponse;

public class OutputView {

    private static final DecimalFormat PRICE_FORMAT = new DecimalFormat("###,###");

    public void printOrdersInfo(List<OrderResponse> orderResponses) {
        newLine();
        System.out.println(OUTPUT_ORDER_INFO_HEADER.get());
        orderResponses.forEach(this::printOrderInfo);
    }

    public void printAmount(int amount) {
        System.out.printf(OUTPUT_TOTAL_AMOUNT_MESSAGE.get(priceFormat(amount)));
        newLine();
    }

    public void printDeliveryFee(int deliveryFee) {
        System.out.printf(OUTPUT_DELIVERY_FEE_MESSAGE.get(priceFormat(deliveryFee)));
        newLine();
    }

    public void printServiceMenu(int quantity) {
        newLine();
        System.out.println(OUTPUT_SERVICE_MENU_HEADER.get());
        System.out.printf(OUTPUT_SERVICE_MENU_MESSAGE.get(quantity));
        newLine();
    }

    public void printFinalResultPrice(int price) {
        newLine();
        System.out.println(OUTPUT_FINAL_RESULT_PRICE_HEADER.get());
        System.out.printf(OUTPUT_FINAL_RESULT_PRICE_MESSAGE.get(priceFormat(price)));
    }

    private void printOrderInfo(OrderResponse orderResponse) {
        System.out.printf(OUTPUT_ORDER_INFO_FORMAT.get(orderResponse.menuName(), orderResponse.quantity(),
                priceFormat(orderResponse.price())));
        newLine();
    }

    private static String priceFormat(int amount) {
        return PRICE_FORMAT.format(amount);
    }

    private void newLine() {
        System.out.print(NEW_LINE.get());
    }
}
