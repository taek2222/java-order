package order.domain;

public class OrderService {

    private final int serviceDumpling;

    public OrderService(int count) {
        this.serviceDumpling = count;
    }

    public int getServiceDumpling() {
        return serviceDumpling;
    }

    public boolean isService() {
        return serviceDumpling != 0;
    }
}
