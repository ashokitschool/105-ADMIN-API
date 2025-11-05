package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shipping_addr")
@Setter
@Getter
public class ShippingAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addrId;
    private String hno;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String addrType;
    private String deleteSw;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
