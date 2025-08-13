package atm;

public class BillValidator {
    public static final int[] ALLOWED_BILLS = {50, 1000, 5000};

    public boolean isValid(int bill) {
        for (int i = 0; i < ALLOWED_BILLS.length; i++) {
            if (bill == ALLOWED_BILLS[i]) {
                return true;
            }
        }
        return false;
    }
}
