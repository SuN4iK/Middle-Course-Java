package atm;

public class CashTransactionException extends RuntimeException {
    public CashTransactionException(String message) {
        super(message);
    }
}
