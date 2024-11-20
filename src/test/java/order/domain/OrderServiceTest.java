package order.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    @Test
    void 메인_수량_만큼_서비스를_추가한다() {
        // given
        int count = 5;
        OrderService orderService = new OrderService(count);

        // when
        int result = orderService.getServiceDumpling();

        // then
        Assertions.assertThat(result)
                .isEqualTo(count);
    }
}