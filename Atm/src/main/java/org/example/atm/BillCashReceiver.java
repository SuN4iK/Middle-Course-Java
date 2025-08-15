package org.example.atm;

public class BillCashReceiver implements CashAcceptor {
    private int total;
    private final BillValidator validator;

    public BillCashReceiver(BillValidator billValidator) {
        this.validator = billValidator;
        this.total = 0;
    }


    @Override
    public void acceptBill(int bill) throws CashTransactionException {
        if(!validator.isValid(bill)) {
            throw new CashTransactionException("Неправильная купюра! Принимаются только 50, 1000 и 5000");
        }
        total += bill;
        System.out.println("Купюра принята, баланс: " + total);
    }

    @Override
    public int getTotal() {
        return total;
    }
}
