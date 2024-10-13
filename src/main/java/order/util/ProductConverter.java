package order.util;

import order.dto.OrderRequestDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductConverter {

    public static final String INPUT_REGEX = ", ";
    public static final String PATTERN_REGEX = "(.+)\\((\\d+)개\\)";

    public static List<OrderRequestDTO> convertInputToProductDTOS(String input) {
        List<OrderRequestDTO> products = new ArrayList<>();

        String[] productStrings = input.split(INPUT_REGEX);
        Pattern pattern = Pattern.compile(PATTERN_REGEX);

        for (String productString : productStrings) {
            Matcher matcher = pattern.matcher(productString);

            if (matcher.matches()) {
                String productName = matcher.group(1);
                int quantity = Integer.parseInt(matcher.group(2));

                OrderRequestDTO newProduct = new OrderRequestDTO(productName, quantity);
                products.add(newProduct);
            }
        }

        return products;
    }
}
