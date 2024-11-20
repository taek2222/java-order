package order.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrdersTest {

    @Test
    void 음료만_주문할_경우_예외가_발생한다() {
        // given
        Order order = new Order(Menu.COLA, 1);
        List<Order> orders = List.of(order);

        // when & then
        Assertions.assertThatThrownBy(() -> new Orders(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }
}