package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "product")
@Setter
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String description;
    private String title;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;

    @CreationTimestamp
    private LocalDate dateCreated;

    @UpdateTimestamp
    private LocalDate lastUpdated;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private ProductCategoryEntity category;


}
