package order.domain.dto;

public record OrderResponse(
        String menuName,
        int quantity,
        int amount
) {
}
