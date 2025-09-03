package CreditSystem.Handlers;

import CreditSystem.Requests.CreditRequest;

public abstract class CreditHandler {
    protected CreditHandler nextHandler;

    public CreditHandler setNext(CreditHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    public abstract void handle(CreditRequest request);

    protected void handleNext(CreditRequest request) {
        if (nextHandler != null && !"REJECTED".equals(request.getStatus())) {
            nextHandler.handle(request);
        }
    }
}
