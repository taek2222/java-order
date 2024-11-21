package order.domain;

import static order.domain.Menu.COLA;
import static order.domain.Menu.PIZZA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import order.domain.dto.OrderResponse;
import order.global.constant.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderTest {

    @ParameterizedTest
    @MethodSource("provideMenus")
    void 메인_메뉴_수량을_정상적으로_반환한다(Menu menu, int quantity, int expected) {
        // given
        Order order = new Order(menu, quantity);

        // when
        int result = order.getQuantityIfMainMenu();

        // then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void 음료_메뉴_여부를_정상적으로_반환한다() {
        // given
        Order order = new Order(COLA, 1);

        // when
        boolean result = order.isDrink();

        // then
        assertThat(result)
                .isTrue();
    }

    @Test
    void 주문_금액을_정상적으로_계산한다() {
        // given
        Order order = new Order(COLA, 1);

        // when
        int result = order.calculateAmount();

        // then
        assertThat(result)
                .isEqualTo(2_000);
    }

    @Test
    void 주문_응답을_정상적으로_생성한다() {
        // given
        int quantity = 1;
        Order order = new Order(COLA, quantity);

        // when
        OrderResponse response = order.createResponse();

        // then
        assertThat(response.menuName()).isEqualTo(COLA.getName());
        assertThat(response.quantity()).isEqualTo(quantity);
        assertThat(response.amount()).isEqualTo(COLA.getPrice() * quantity);
    }

    @Test
    void 최대_수량_이상_주문시_예외가_발생한다() {
        // given
        int quantity = 11;

        // when & then
        assertThatThrownBy(() -> new Order(PIZZA, quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ORDER_QUANTITY.get(10));
    }

    private static Stream<Arguments> provideMenus() {
        return Stream.of(
                Arguments.of(PIZZA, 5, 5),
                Arguments.of(COLA, 1, 0)
        );
    }
}