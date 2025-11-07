package in.ashokit.service;

import in.ashokit.dto.ProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    public ProductDto createProduct(Integer categoryId, ProductDto productDto, MultipartFile productImage) throws IOException;

    public ProductDto updateProduct(Integer productId, ProductDto productDto, MultipartFile productImage);

    public ProductDto deleteProduct(Integer productId);

    public ProductDto getProduct(Integer productId);

    public List<ProductDto> getProductsByCategory(Integer categoryId);

}
