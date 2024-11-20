package order.domain;

import static order.domain.Menu.PIZZA;
import static order.domain.Menu.findMenuByName;
import static org.assertj.core.api.Assertions.assertThat;

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
}