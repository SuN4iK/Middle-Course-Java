package org.example.atm;

public interface CashGiver {
    void dispenseMinBills(int amount) throws CashTransactionException;
    void dispenseChange(int amount) throws CashTransactionException;
}
