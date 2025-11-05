package in.ashokit.service;

import in.ashokit.dto.ProductDto;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    @Override
    public ProductDto createProduct(Integer categoryId, ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto updateProduct(Integer productId, ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto deleteProduct(Integer productId) {
        return null;
    }

    @Override
    public ProductDto getProduct(Integer productId) {
        return null;
    }

    @Override
    public List<ProductDto> getProductsByCategory(Integer categoryId) {
        return List.of();
    }
}
