package in.ashokit.service;

import in.ashokit.dto.ProductCategoryDto;
import in.ashokit.entity.ProductCategoryEntity;
import in.ashokit.mapper.ProductCategoryMapper;
import in.ashokit.repo.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepo categoryRepo;

    @Override
    public ProductCategoryDto createCategory(ProductCategoryDto categoryDto) {
        ProductCategoryEntity byCategoryNameIgnoreCase = categoryRepo.findByCategoryNameIgnoreCase(categoryDto.getCategoryName());
        if (byCategoryNameIgnoreCase != null) {
            throw new RuntimeException("Duplicate Category Found");
        }
        ProductCategoryEntity productCategoryEntity = ProductCategoryMapper.convertToEntity(categoryDto);
        productCategoryEntity.setActive("true");
        categoryRepo.save(productCategoryEntity);
        return ProductCategoryMapper.convertToDto(productCategoryEntity);
    }

    @Override
    public ProductCategoryDto updateCategory(Integer categoryId, ProductCategoryDto categoryDto) {
        return null;
    }

    @Override
    public ProductCategoryDto getCategoryById(Integer categoryId) {
        return null;
    }

    @Override
    public List<ProductCategoryDto> getAllCategories() {
        return List.of();
    }

    @Override
    public ProductCategoryDto deleteCategory(Integer categoryId) {
        return null;
    }
}
