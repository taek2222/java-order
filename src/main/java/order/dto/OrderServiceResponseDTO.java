package order.dto;

public record OrderServiceResponseDTO(
        String product,
        Integer quantity
) {
}
