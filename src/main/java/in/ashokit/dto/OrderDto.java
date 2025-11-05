package in.ashokit.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {

    private Integer orderId;
    private String orderTrackingNum;
    private Double totalPrice;
    private Integer totalQuantity;
    private String orderStatus;
    private LocalDate deliveyDate;
    private String paymentStatus;
    private String razorpayOrderId;
    private String razorpayPaymentId;
    private LocalDate dateCreated;
    private LocalDate lastUpdated;
    private String customerEmail;
}
