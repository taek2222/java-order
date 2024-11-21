package order.domain;

import static org.assertj.core.api.Assertions.assertThat;

import order.domain.dto.ServiceResponse;
import org.junit.jupiter.api.Test;

class ServiceMenuTest {

    @Test
    void 서비스_메뉴가_정상적으로_생성된다() {
        // given
        int quantity = 5;

        // when
        ServiceMenu result = new ServiceMenu(quantity);

        // then
        assertThat(result)
                .isNotNull();
    }

    @Test
    void 서비스_메뉴_응답을_정상적으로_생성한다() {
        // given
        int quantity = 5;
        ServiceMenu serviceMenu = new ServiceMenu(quantity);

        // when
        ServiceResponse response = serviceMenu.createResponse();

        // then
        assertThat(response.menuName()).isEqualTo(Menu.DUMPLING);
        assertThat(response.quantity()).isEqualTo(quantity);
    }

    @Test
    void 서비스_수량이_있을_경우_true를_반환한다() {
        // given
        ServiceMenu serviceMenu = new ServiceMenu(5);

        // when
        boolean result = serviceMenu.hasServiceQuantity();

        // then
        assertThat(result)
                .isTrue();
    }

    @Test
    void 서비스_수량이_없을_경우_false를_반환한다() {
        // given
        ServiceMenu serviceMenu = new ServiceMenu(0);

        // when
        boolean result = serviceMenu.hasServiceQuantity();

        // then
        assertThat(result)
                .isFalse();
    }
}