package CreditSystem.Handlers;

import CreditSystem.Requests.CreditRequest;

public class EmploymentHandler extends CreditHandler {
    @Override
    public void handle(CreditRequest request) {
        try {
            if (request.getEmploymentMonths() < 6) {
                request.setStatus("REJECTED");
                request.setRejectionReason("Employment period too short");
                return;
            }

            System.out.println("Employment check passed");

            // Если все проверки пройдены - одобряем
            if (nextHandler == null && !"REJECTED".equals(request.getStatus())) {
                request.setStatus("APPROVED");
            }

            handleNext(request);
        } catch (Exception e) {
            System.err.println("Error in employment check: " + e.getMessage());
        }
    }
}
