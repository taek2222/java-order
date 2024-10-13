package order.exception;

public class OrderException extends RuntimeException{

    public OrderException(String message) {
        super("[ERROR]: " + message);
    }
}
