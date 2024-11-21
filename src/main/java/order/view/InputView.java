package order.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_ORDER_MENU_MESSAGE = "주문하실 메뉴와 수량을 입력해주세요. ex) 피자(2개), 감자튀김(1개), 콜라(3개)";

    public String readOrderMenu() {
        System.out.println(INPUT_ORDER_MENU_MESSAGE);
        return SCANNER.nextLine();
    }

    public void closeScanner() {
        SCANNER.close();
    }
}
