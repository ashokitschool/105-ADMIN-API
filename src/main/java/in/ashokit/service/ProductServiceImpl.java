package in.ashokit.service;

import in.ashokit.dto.ProductDto;
import in.ashokit.entity.ProductCategoryEntity;
import in.ashokit.entity.ProductEntity;
import in.ashokit.mapper.ProductMapper;
import in.ashokit.repo.ProductCategoryRepo;
import in.ashokit.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductCategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Value("${images-upload-dir}")
    private String imagesUploadDir;


    @Override
    public ProductDto createProduct(Integer categoryId, ProductDto productDto, MultipartFile productImage) throws IOException {

        String filename = productImage.getOriginalFilename();

        Path filePath = Paths.get(imagesUploadDir + filename);

        // Create uploading dir if not available
        if (!Files.exists(filePath.getParent())) {
            try {
                Files.createDirectories(filePath.getParent());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // copying file into target directory
        Files.copy(productImage.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // setting file path to DTO object
        productDto.setImageUrl(filePath.toString());

        // save product obj
        ProductCategoryEntity productCategoryEntity = categoryRepo.findById(categoryId).orElseThrow();
        ProductEntity productEntity = ProductMapper.convertToEntity(productDto);
        productEntity.setCategory(productCategoryEntity);
        productRepo.save(productEntity);

        return ProductMapper.convertToDto(productEntity);

    }

    @Override
    public ProductDto updateProduct(Integer productId, ProductDto productDto, MultipartFile productImage) throws IOException {

        ProductEntity productEntity = productRepo.findById(productId).orElseThrow();
        String filename = productImage.getOriginalFilename();
        Path filePath = Paths.get(imagesUploadDir + filename);

        // Create uploading dir if not available
        if (!Files.exists(filePath.getParent())) {
            try {
                Files.createDirectories(filePath.getParent());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // copying file into target directory
        Files.copy(productImage.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // setting file path to DTO object
        productDto.setImageUrl(filePath.toString());

        productEntity.setUnitPrice(productDto.getUnitPrice());
        productEntity.setName(productDto.getName());
        productEntity.setTitle(productDto.getTitle());
        productEntity.setActive(productDto.isActive());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setImageUrl(productDto.getImageUrl());

        productRepo.save(productEntity); // UPSERT

        return ProductMapper.convertToDto(productEntity);
    }

    @Override
    public ProductDto deleteProduct(Integer productId) {

        ProductEntity productEntity = productRepo.findById(productId).orElseThrow();
        productEntity.setActive(false);
        productRepo.save(productEntity);

        return ProductMapper.convertToDto(productEntity);
    }

    @Override
    public ProductDto getProduct(Integer productId) {
        ProductEntity productEntity = productRepo.findById(productId).orElseThrow();
        return ProductMapper.convertToDto(productEntity);
    }

    @Override
    public List<ProductDto> getProductsByCategory(Integer categoryId) {

        List<ProductEntity> productEntityList = productRepo.findByCategoryCategoryIdAndActive(categoryId, true);

        return productEntityList.stream()
                .map(ProductMapper::convertToDto)
                .toList();

    }
}
