package in.ashokit.repo;

import in.ashokit.entity.ShippingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingAddressRepo extends JpaRepository<ShippingAddressEntity, Integer> {

    // select * from shipping_addr where customer_id = ? and delete_sw=?
    public List<ShippingAddressEntity> findByCustomerCustomerIdAndDeleteSw(Integer customerId, String deleteSw);
}
