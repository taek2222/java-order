package order.validation;

import order.constant.ProductType;
import order.domain.Order;
import order.exception.OrderException;

import java.util.List;

public class OrderValidator {

    public void validateProductQuantity(Order product) {
        int quantity = product.getQuantity();

        if (quantity < 0 || quantity > 10)
            throw new OrderException("상품 갯수는 최소 0개 ~ 최대 10개 입니다.");
    }

    public void validateOnlyDrinks(List<Order> orders) {
        boolean allMatch = orders.stream()
                .allMatch(order -> order.getProduct().getType().equals(ProductType.DRINK));

        if (allMatch)
            throw new OrderException("음료만으로는 주문할 수 없습니다.");
    }

    public void validateMinimumPrice(int orderTotalPrice) {
        if(orderTotalPrice < 30000)
            throw new OrderException("최소 주문 금액을 만족하지 못했습니다.");
    }
}
