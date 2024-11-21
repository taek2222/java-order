package order.global.util;

import static order.domain.Menu.findMenuByName;
import static order.global.constant.ErrorMessage.INVALID_ORDER_FORMAT;
import static order.global.validate.CommonValidator.validateIsNumeric;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import order.domain.Menu;
import order.domain.Order;

public class OrderInputParser {

    private static final String ORDERS_DELIMITER = ",";
    private static final String ORDER_PATTERN = "^([가-힣\\s]+)\\((\\d+)개\\)$";
    private static final int ORDER_MATCHER_COUNT = 2;
    private static final Pattern PATTERN = Pattern.compile(ORDER_PATTERN);

    public static List<Order> parseOrderInput(final String input) {
        return Arrays.stream(input.split(ORDERS_DELIMITER))
                .map(OrderInputParser::parseOrderElement)
                .toList();
    }

    private static Order parseOrderElement(final String element) {
        Matcher matcher = PATTERN.matcher(element.trim());
        validateMatcher(matcher);

        Menu menu = findMenuByName(matcher.group(1));
        int quantity = parseQuantity(matcher.group(2));

        return createOrder(menu, quantity);
    }

    private static int parseQuantity(final String matcher) {
        validateIsNumeric(matcher);
        return Integer.parseInt(matcher);
    }

    private static void validateMatcher(final Matcher matcher) {
        if (!matcher.find() || matcher.groupCount() != ORDER_MATCHER_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER_FORMAT.get());
        }
    }

    private static Order createOrder(final Menu menu, final int quantity) {
        return new Order(menu, quantity);
    }
}
