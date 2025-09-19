package CreditSystem.Facades;

import CreditSystem.Factorys.CreditHandlerFactory;
import CreditSystem.Requests.CreditRequest;
import CreditSystem.Handlers.CreditHandler;

public class CreditSystemFacade {
    private final CreditHandlerFactory handlerFactory;

    public CreditSystemFacade() {
        this.handlerFactory = new CreditHandlerFactory();
    }

    public CreditRequest processCreditApplication(CreditRequest request) {
        try {
            System.out.println("Processing credit application for: " + request.getClientName());

            CreditHandler chain = handlerFactory.createChain();
            if (chain != null) {
                chain.handle(request);
            }

            if (!"REJECTED".equals(request.getStatus())) {
                request.setStatus("APPROVED");
            }

            return request;
        } catch (Exception e) {
            System.err.println("Error processing application: " + e.getMessage());
            request.setStatus("ERROR");
            request.setRejectionReason("System error: " + e.getMessage());
            return request;
        }
    }
}
