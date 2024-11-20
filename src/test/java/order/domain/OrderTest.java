package order.domain;

import order.global.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void 최대_수량_이상_주문시_예외가_발생한다() {
        // given
        int quantity = 11;

        // when & then
        Assertions.assertThatThrownBy(() -> new Order(Menu.PIZZA, quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ORDER_QUANTITY.get(10));
    }
}