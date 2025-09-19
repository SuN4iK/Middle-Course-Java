package CreditSystem;

import CreditSystem.Facades.CreditSystemFacade;
import CreditSystem.Requests.CreditRequest;

public class CreditSystemDemo {
    public static void main(String[] args) {
        try {
            CreditSystemFacade creditSystem = new CreditSystemFacade();
            CreditRequest goodRequest = CreditRequest.builder()
                    .clientName("Ivan Ivanov")
                    .age(50)
                    .income(100000)
                    .creditScore(750)
                    .requestedAmount(300000)
                    .employmentMonths(24)
                    .hasCriminalRecord(false)
                    .build();

            System.out.println("=== Good application ===");
            CreditRequest result1 = creditSystem.processCreditApplication(goodRequest);
            System.out.println("Result: " + result1.getStatus() +
                    ", Amount: " + result1.getApprovedAmount());

            CreditRequest badRequest = CreditRequest.builder()
                    .clientName("Petya Petrov")
                    .age(17)
                    .income(20000)
                    .creditScore(450)
                    .requestedAmount(500000)
                    .employmentMonths(3)
                    .hasCriminalRecord(true)
                    .build();

            System.out.println("\n=== Bad application ===");
            CreditRequest result2 = creditSystem.processCreditApplication(badRequest);
            System.out.println("Result: " + result2.getStatus() +
                    ", Reason: " + result2.getRejectionReason());

        } catch (Exception e) {
            System.err.println("Demo error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
