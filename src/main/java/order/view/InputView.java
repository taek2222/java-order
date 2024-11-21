package order.view;

import static order.global.constant.ViewMessage.INPUT_ORDER_MENU_MESSAGE;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String readOrderMenu() {
        System.out.println(INPUT_ORDER_MENU_MESSAGE.get());
        return SCANNER.nextLine();
    }

    public void closeScanner() {
        SCANNER.close();
    }
}
