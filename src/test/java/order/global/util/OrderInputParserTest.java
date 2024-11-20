package order.global.util;

import static order.global.constant.ErrorMessage.INVALID_ORDER_FORMAT;
import static order.global.util.OrderInputParser.parseOrderInput;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import order.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderInputParserTest {

    @Test
    void 주문_입력을_메뉴와_수량으로_분리한다() {
        // given
        String input = "피자(1개), 감자튀김(1개)";

        // when
        List<Order> orders = parseOrderInput(input);

        // then
        assertThat(orders)
                .hasSize(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "피자(개)",
            "피자(0개)",
            "피자(-1개)",
            "피자(1.5개)",
            "피자1개",
            "감자 튀 김(1개)",
            "피자(1개), 햄버거(2개), ",
            "피자(1개, 감자튀김(2개)",
            "피자(1개) 감자튀김(1개)",
            "(1개)",
            "피자()"
    })
    void 주문_형식_및_조건이_잘못된_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> parseOrderInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER_FORMAT.get());
    }
}