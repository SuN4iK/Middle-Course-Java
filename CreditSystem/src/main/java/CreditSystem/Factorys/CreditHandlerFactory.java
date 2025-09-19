package CreditSystem.Factorys;

import CreditSystem.Handlers.*;

public class CreditHandlerFactory {
    public CreditHandler createChain() {
        try {
            var ageHandler = new AgeHandler();
            var incomeHandler = new IncomeHandler();
            var creditScoreHandler = new CreditScoreHandler();
            var criminalHandler = new CriminalRecordHandler();
            var employmentHandler = new EmploymentHandler();

            ageHandler.setNext(incomeHandler)
                    .setNext(creditScoreHandler)
                    .setNext(criminalHandler)
                    .setNext(employmentHandler);

            return ageHandler;
        } catch (Exception e) {
            System.err.println("Error creating handler chain: " + e.getMessage());
            return null;
        }
    }
}
