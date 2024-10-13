package order.util;

import order.dto.OrderRequestDTO;
import order.exception.OrderException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductConverter {

    private static final String INPUT_REGEX = ", ";
    private static final String PATTERN_REGEX = "(.+)\\((\\d+)개\\)";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_REGEX);

    public List<OrderRequestDTO> convertInputToProductDTOS(String input) {
        return Stream.of(input.split(INPUT_REGEX))
                .map(this::createOrderRequestDTO)
                .collect(Collectors.toList());
    }

    private  OrderRequestDTO createOrderRequestDTO(String productNameString) {
        Matcher matcher = PATTERN.matcher(productNameString);

        if (matcher.matches()) {
            String productName = matcher.group(1);
            Integer quantity = Integer.parseInt(matcher.group(2));
            return new OrderRequestDTO(productName, quantity);
        }
        throw new OrderException("주문 형식에 알맞지 않습니다.");
    }
}
