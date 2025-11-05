package in.ashokit.dto;

import lombok.Data;

@Data
public class PurchaseOrderResponseDto {

    private String razorpayOrderId;
    private String orderStatus;
    private String orderTrackingNumber;
    private String paymentStatus;
}
