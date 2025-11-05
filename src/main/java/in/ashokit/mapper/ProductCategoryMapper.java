package in.ashokit.mapper;

import in.ashokit.dto.CustomerDto;
import in.ashokit.dto.ProductCategoryDto;
import in.ashokit.entity.CustomerEntity;
import in.ashokit.entity.ProductCategoryEntity;
import org.modelmapper.ModelMapper;

public class ProductCategoryMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static ProductCategoryDto convertToDto(ProductCategoryEntity categoryEntity) {
        return mapper.map(categoryEntity, ProductCategoryDto.class);
    }

    public static ProductCategoryEntity convertToEntity(ProductCategoryDto categoryDto) {
        return mapper.map(categoryDto, ProductCategoryEntity.class);
    }
}
