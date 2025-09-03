package CreditSystem.Handlers;

import CreditSystem.Requests.CreditRequest;

public class AgeHandler extends CreditHandler {
    @Override
    public void handle(CreditRequest request) {
        try {
            if (request.getAge() < 18) {
                request.setStatus("REJECTED");
                request.setRejectionReason("Too young..");
                return;
            }

            if (request.getAge() > 70) {
                request.setStatus("REJECTED");
                request.setRejectionReason("Too old..");
                return;
            }
            System.out.println("Age check passed.");
            handleNext(request);
        } catch (Exception e) {
            System.out.println("Error in Age check: " + e.getMessage());
        }
    }
}
