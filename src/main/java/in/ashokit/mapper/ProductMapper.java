package in.ashokit.mapper;

import in.ashokit.dto.ProductCategoryDto;
import in.ashokit.dto.ProductDto;
import in.ashokit.entity.ProductCategoryEntity;
import in.ashokit.entity.ProductEntity;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static ProductDto convertToDto(ProductEntity productEntity) {
        return mapper.map(productEntity, ProductDto.class);
    }

    public static ProductEntity convertToEntity(ProductDto productDto) {
        return mapper.map(productDto, ProductEntity.class);
    }
}
