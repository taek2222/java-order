package order.dto;

import java.util.List;

public record OrderResponseDTO(
    List<OrderProductResponseDTO> orderProductResponseDTOS,
    Integer orderTotalPrice,
    Integer delivery,
    OrderServiceResponseDTO orderServiceResponseDTO
    ) {
}
