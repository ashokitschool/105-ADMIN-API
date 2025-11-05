package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order_items")
@Setter
@Getter
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    private String imageUrl;
    private Integer quantity;
    private Double unitPrice;
    private String productName;

    @ManyToOne
    @JoinColumn(name="order_id")
    private OrderEntity order;

}
