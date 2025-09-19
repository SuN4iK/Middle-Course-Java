package CreditSystem.Handlers;

import CreditSystem.Requests.CreditRequest;

public class CriminalRecordHandler extends CreditHandler {
    @Override
    public void handle(CreditRequest request) {
        try {
            if (request.isHasCriminalRecord()) {
                request.setStatus("REJECTED");
                request.setRejectionReason("Criminal record detected");
                return;
            }

            System.out.println("Criminal record check passed");
            handleNext(request);
        } catch (Exception e) {
            System.err.println("Error in criminal record check: " + e.getMessage());
        }
    }
}
