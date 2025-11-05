package in.ashokit.service;

import in.ashokit.dto.ProductDto;

import java.util.List;

public interface ProductService {

    public ProductDto createProduct(Integer categoryId, ProductDto productDto);

    public ProductDto updateProduct(Integer productId, ProductDto productDto);

    public ProductDto deleteProduct(Integer productId);

    public ProductDto getProduct(Integer productId);

    public List<ProductDto> getProductsByCategory(Integer categoryId);

}
