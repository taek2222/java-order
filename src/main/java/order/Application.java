package order;

import order.controller.OrderController;
import order.view.InputView;
import order.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OrderController orderController = new OrderController(
                new InputView(),
                new OutputView()
        );

        orderController.run();
    }
}
