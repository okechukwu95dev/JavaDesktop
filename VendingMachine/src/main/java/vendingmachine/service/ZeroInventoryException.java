package vendingmachine.service;

public class ZeroInventoryException extends Exception {

    public ZeroInventoryException(String message) {
        super(message);
    }

    public ZeroInventoryException(String message, Throwable cause) {
        super(message, cause);
    }

}
