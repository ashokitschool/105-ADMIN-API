package in.ashokit.repo;

import in.ashokit.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

    public List<ProductEntity> findByCategoryCategoryId(Long categoryId);
    public List<ProductEntity> findByNameContainingIgnoreCase(String productName);


}
