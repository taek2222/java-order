package order.domain;

import static order.domain.Menu.DUMPLING;

import order.domain.dto.ServiceResponse;

public class ServiceMenu {

    private static final Menu SERVICE_MENU = DUMPLING;
    private static final int NO_SERVICE_QUANTITY = 0;

    private final Menu menu;
    private final int quantity;

    public ServiceMenu(final int quantity) {
        this.menu = SERVICE_MENU;
        this.quantity = quantity;
    }

    public ServiceResponse createResponse() {
        return new ServiceResponse(
                menu.getName(),
                quantity
        );
    }

    public boolean hasServiceQuantity() {
        return quantity != NO_SERVICE_QUANTITY;
    }
}
