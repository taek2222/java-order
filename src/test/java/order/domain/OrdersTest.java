package order.domain;

import static order.domain.Menu.COLA;
import static order.domain.Menu.PIZZA;
import static order.global.constant.ErrorMessage.INVALID_ORDERS_MINIMUM;
import static order.global.constant.ErrorMessage.INVALID_ORDER_ONLY_DRINK;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrdersTest {

    @Test
    void 정상으로_주문할_경우_객체가_생성된다() {
        // given
        Order test1 = new Order(PIZZA, 1);
        Order test2 = new Order(COLA, 1);
        List<Order> orders = List.of(test1, test2);

        // when
        Orders result = new Orders(orders);

        // then
        Assertions.assertThat(result)
                .isNotNull();
    }

    @Test
    void 최소_주문_갯수가_아닌_경우_예외가_발생한다() {
        // given
        List<Order> orders = List.of();

        // when & then
        Assertions.assertThatThrownBy(() -> new Orders(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDERS_MINIMUM.get());
    }

    @Test
    void 음료만_주문할_경우_예외가_발생한다() {
        // given
        Order order = new Order(COLA, 1);
        List<Order> orders = List.of(order);

        // when & then
        Assertions.assertThatThrownBy(() -> new Orders(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER_ONLY_DRINK.get());
    }
}