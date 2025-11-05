package in.ashokit.service;

import in.ashokit.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {

    public ProductCategoryDto createCategory(ProductCategoryDto categoryDto);

    public ProductCategoryDto updateCategory(Integer categoryId, ProductCategoryDto categoryDto);

    public ProductCategoryDto getCategoryById(Integer categoryId);

    public List<ProductCategoryDto> getAllCategories();

    public ProductCategoryDto deleteCategory(Integer categoryId);

}