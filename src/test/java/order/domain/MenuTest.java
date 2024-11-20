package order.domain;

import static order.domain.Menu.PIZZA;
import static order.domain.Menu.findMenuByName;
import static order.global.constant.ErrorMessage.INVALID_ORDER_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void 고객의_메뉴를_찾아_메뉴의_정보를_반환한다() {
        // given
        String menuName = "피자";

        // when
        Menu result = findMenuByName(menuName);

        // then
        assertThat(result)
                .isEqualTo(PIZZA);
    }

    @Test
    void 일치하는_주문_메뉴가_없을_경우_예외가_발생한다() {
        // given
        String menuName = "없는 메뉴";

        // when & then
        assertThatThrownBy(() -> findMenuByName(menuName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER_FORMAT.getMessage());
    }
}