package in.ashokit.dto;

import lombok.Data;

@Data
public class OrderItemDto {

    private Integer itemId;
    private String imageUrl;
    private Integer quantity;
    private Double unitPrice;
    private String productName;
}
