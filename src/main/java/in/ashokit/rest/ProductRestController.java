package in.ashokit.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.ashokit.dto.ProductDto;
import in.ashokit.response.ApiResponse;
import in.ashokit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ApiResponse<ProductDto>> createProduct(@RequestParam("productJson") String productJson,
                                                                 @RequestParam("categoryId") Integer categoryId,
                                                                 @RequestParam("productImage") MultipartFile productImage) {
        ApiResponse<ProductDto> response = new ApiResponse<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            ProductDto productDto = mapper.readValue(productJson, ProductDto.class);
            ProductDto savedProduct = productService.createProduct(categoryId, productDto, productImage);

            if (savedProduct.getProductId() != null) {
                response.setData(savedProduct);
                response.setMsg("Product Saved");
                response.setStatus(201);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                response.setData(null);
                response.setMsg("Product Failed To Save");
                response.setStatus(500);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            response.setData(null);
            response.setMsg("⚠️ Exception Occurred: " + e.getMessage());
            response.setStatus(500);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product")
    public ResponseEntity<ApiResponse<ProductDto>> updateProduct(@RequestParam("productJson") String productJson,
                                                                 @RequestParam("productId") Integer productId,
                                                                 @RequestParam("productImage") MultipartFile productImage) {
        ApiResponse<ProductDto> response = new ApiResponse<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            ProductDto productDto = mapper.readValue(productJson, ProductDto.class);
            ProductDto savedProduct = productService.updateProduct(productId, productDto, productImage);

            if (savedProduct.getProductId() != null) {
                response.setData(savedProduct);
                response.setMsg("Product Updated");
                response.setStatus(200);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                response.setData(null);
                response.setMsg("Product Failed To Update");
                response.setStatus(500);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            response.setData(null);
            response.setMsg("Exception Occurred: " + e.getMessage());
            response.setStatus(500);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ApiResponse<ProductDto>> getProduct(@PathVariable("productId") Integer productId) {
        ApiResponse<ProductDto> response = new ApiResponse<>();

        ProductDto product = productService.getProduct(productId);
        if (product != null) {
            response.setData(product);
            response.setMsg("Fetched Product successfully");
            response.setStatus(200);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setData(null);
            response.setMsg("No Product Found");
            response.setStatus(500);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<ApiResponse<ProductDto>> deleteProduct(@PathVariable("productId") Integer productId) {
        ApiResponse<ProductDto> response = new ApiResponse<>();
        ProductDto product = productService.deleteProduct(productId);
        if (product != null) {
            response.setData(product);
            response.setMsg("Product Deleted successfully");
            response.setStatus(200);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setData(null);
            response.setMsg("No Product Found");
            response.setStatus(500);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<ApiResponse<List<ProductDto>>> getProductsByCategory(@PathVariable("categoryId") Integer categoryId) {
        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> productsList = productService.getProductsByCategory(categoryId);
        if (productsList.isEmpty()) {
            response.setData(productsList);
            response.setMsg("Products Fetched successfully");
            response.setStatus(200);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setData(null);
            response.setMsg("No Products Found");
            response.setStatus(500);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}