package order.dto;

public record OrderProductResponseDTO(
        String product,
        Integer quantity,
        Integer price
) {
}
