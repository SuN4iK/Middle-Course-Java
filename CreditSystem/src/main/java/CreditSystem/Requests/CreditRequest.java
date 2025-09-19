package CreditSystem.Requests;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class CreditRequest {
    private String clientName;
    private int age;
    private double income;
    private int creditScore;
    private double requestedAmount;
    private int employmentMonths;
    private boolean hasCriminalRecord;
    private String status;
    private double approvedAmount;
    private String rejectionReason;
}
