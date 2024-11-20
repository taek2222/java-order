package order.domain;

import static order.global.constant.ErrorMessage.INVALID_ORDER_MINIMUM_AMOUNT;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderResultTest {

    @Test
    void 최소_주문_금액에_미치지_못할_경우_예외가_발생한다() {
        // given
        int totalPrice = 20000;

        // when & then
        Assertions.assertThatThrownBy(() -> new OrderResult(totalPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER_MINIMUM_AMOUNT.get());
    }
}