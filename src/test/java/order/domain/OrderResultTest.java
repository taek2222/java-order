package order.domain;

import static order.global.constant.ErrorMessage.INVALID_ORDER_MINIMUM_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OrderResultTest {

    @ParameterizedTest(name = "테스트 금액: {arguments}")
    @CsvSource({"35000, 2000", "75000, 1000", "100000, 0"})
    void 합산_가격에_따라_배달비를_측정한다(int amount, int deliveryFee) {
        // given
        OrderResult orderResult = new OrderResult(amount);

        // when
        int result = orderResult.getDeliveryFee();

        // then
        assertThat(result)
                .isEqualTo(deliveryFee);
    }

    @ParameterizedTest(name = "테스트 금액: {arguments}")
    @ValueSource(ints = {-1_000, 0, 29_999})
    void 최소_주문_금액에_미치지_못할_경우_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> new OrderResult(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER_MINIMUM_AMOUNT.get());
    }

    @ParameterizedTest
    @CsvSource({"35000, 37000", "75000, 76000", "100000, 100000"})
    void 최종_금액을_정상적으로_계산한다(int amount, int expected) {
        // given
        OrderResult orderResult = new OrderResult(amount);

        // when
        int result = orderResult.calculateFinalAmount();

        // then
        assertThat(result)
                .isEqualTo(expected);
    }
}