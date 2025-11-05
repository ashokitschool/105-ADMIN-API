package in.ashokit.repo;

import in.ashokit.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

    public OrderEntity findByOrderTrackingNum(String orderTrackingNum);

    public List<OrderEntity> findByCustomerEmail(String email);

}
