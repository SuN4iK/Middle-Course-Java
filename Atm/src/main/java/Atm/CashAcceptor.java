package Atm;

public interface CashAcceptor {
    void acceptBill(int bill) throws CashTransactionException;
    int getTotal();
}
