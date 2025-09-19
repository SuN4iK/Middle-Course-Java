package CreditSystem.Handlers;

import CreditSystem.Requests.CreditRequest;

public class IncomeHandler extends CreditHandler {
    @Override
    public void handle(CreditRequest request) {
        try {
            double minIncome = request.getRequestedAmount() * 0.1;
            if (request.getIncome() < minIncome) {
                request.setStatus("REJECTED");
                request.setRejectionReason("Insufficient income");
                return;
            }

            System.out.println("Income check passed");
            handleNext(request);
        } catch (Exception e) {
            System.err.println("Error in income check: " + e.getMessage());
        }
    }
}
