package order.domain;

import order.domain.dto.ServiceResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ServiceMenuTest {

    @Test
    void 메인_수량_만큼_서비스를_추가한다() {
        // given
        int count = 5;
        ServiceMenu orderService = new ServiceMenu(count);

        // when
        ServiceResponse response = orderService.createResponse();

        // then
        Assertions.assertThat(response.quantity())
                .isEqualTo(count);
    }
}