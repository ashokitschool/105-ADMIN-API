package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Setter
@Getter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String name;
    private String email;
    private String password;
    private String pwdUpdated;
    private String phoneNo;
    @CreationTimestamp
    @Column(name="date_created", updatable = false)
    private LocalDate dateCreated;

    @UpdateTimestamp
    @Column(name="last_updated", insertable = false)
    private LocalDate lastUpdated;

}
