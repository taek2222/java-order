package order.global.validate;

import static order.global.constant.ErrorMessage.INVALID_ORDER_FORMAT;

public class CommonValidator {

    public static void validateIsNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER_FORMAT.get());
        }
    }
}
