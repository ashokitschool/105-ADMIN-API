package in.ashokit.repo;

import in.ashokit.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<ProductCategoryEntity, Integer> {

    public ProductCategoryEntity findByCategoryNameIgnoreCase(String categoryName);
}
