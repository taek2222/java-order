package order.domain;

import static order.global.constant.ErrorMessage.INVALID_ORDER_MINIMUM_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderResultTest {

    @ParameterizedTest(name = "테스트 금액: {arguments}")
    @ValueSource(ints = {-1_000, 0, 29_999})
    void 최소_주문_금액에_미치지_못할_경우_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> new OrderResult(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER_MINIMUM_AMOUNT.get());
    }
}