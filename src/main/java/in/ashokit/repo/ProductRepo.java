package in.ashokit.repo;

import in.ashokit.entity.ProductEntity;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

    public List<ProductEntity> findByCategoryCategoryIdAndActive(Integer categoryId, boolean active);
    public List<ProductEntity> findByNameContainingIgnoreCase(String productName);

}
