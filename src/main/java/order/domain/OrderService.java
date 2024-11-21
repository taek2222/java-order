package order.domain;

import order.domain.dto.ServiceResponse;

public class OrderService {

    private final Menu menu;
    private final int quantity;

    public OrderService(int count) {
        this.menu = Menu.DUMPLING;
        this.quantity = count;
    }

    public ServiceResponse createServiceResponse() {
        return new ServiceResponse(
                menu.getName(),
                quantity
        );
    }

    public boolean isService() {
        return quantity != 0;
    }
}
