package CreditSystem.Handlers;

import CreditSystem.Requests.CreditRequest;

public class CreditScoreHandler extends CreditHandler {
    @Override
    public void handle(CreditRequest request) {
        try {
            if (request.getCreditScore() < 500) {
                request.setStatus("REJECTED");
                request.setRejectionReason("Poor credit score");
                return;
            }
            double creditLimit = calculateCreditLimit(request.getCreditScore());
            request.setApprovedAmount(Math.min(request.getRequestedAmount(), creditLimit));

            System.out.println("Credit score check passed. Approved: " + request.getApprovedAmount());
            handleNext(request);
        } catch (Exception e) {
            System.err.println("Error in credit score check: " + e.getMessage());
        }

    }

    private double calculateCreditLimit(int creditScore) {
        if (creditScore >= 800) return 1_000_000;
        if (creditScore >= 700) return 500_000;
        if (creditScore >= 600) return 300_000;
        return 100_000;
    }
}
