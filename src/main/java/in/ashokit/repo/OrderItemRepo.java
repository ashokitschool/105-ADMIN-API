package in.ashokit.repo;

import in.ashokit.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItemEntity, Integer> {
}
