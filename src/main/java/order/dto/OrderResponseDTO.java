package order.dto;

import java.util.List;

public record OrderResponseDTO(
    List<OrderProductResponseDTO> orderProductResponseDTOS,
    Integer ordersPrice,
    Integer delivery,
    OrderServiceResponseDTO orderServiceResponseDTO,
    Integer orderTotalPrice
    ) {
}
