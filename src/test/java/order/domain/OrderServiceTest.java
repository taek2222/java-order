package order.domain;

import order.domain.dto.ServiceResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    @Test
    void 메인_수량_만큼_서비스를_추가한다() {
        // given
        int count = 5;
        OrderService orderService = new OrderService(count);

        // when
        ServiceResponse response = orderService.createServiceResponse();

        // then
        Assertions.assertThat(response.quantity())
                .isEqualTo(count);
    }
}