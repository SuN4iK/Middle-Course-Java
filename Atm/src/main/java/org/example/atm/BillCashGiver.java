package org.example.atm;

import java.util.HashMap;
import java.util.Map;

public class BillCashGiver implements CashGiver {
    private final int[] ALLOWED_BILLS = {50, 1000, 5000};


    @Override
    public void dispenseMinBills(int amount) throws CashTransactionException {
        Map<Integer, Integer> bills = new HashMap<>();
        int remaining = amount;

        for (int bill : ALLOWED_BILLS) {
            if (remaining >= bill) {
                int count = remaining / bill;
                bills.put(bill, count);
                remaining -= count * bill;
            }
        }
        System.out.println("Выдано:");
        bills.forEach((bill, count) -> System.out.println(count + " x " + bill + " руб."));

    }

    @Override
    public void dispenseChange(int amount) throws CashTransactionException {
        if (amount % 50 != 0) {
            throw new CashTransactionException("Сдачу можно выдать только кратную 50 руб.!");
        }
        dispenseMinBills(amount);

    }
}
