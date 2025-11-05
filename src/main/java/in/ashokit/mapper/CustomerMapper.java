package in.ashokit.mapper;

import in.ashokit.dto.CustomerDto;
import in.ashokit.entity.CustomerEntity;
import org.modelmapper.ModelMapper;

public class CustomerMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static CustomerDto convertToDto(CustomerEntity customerEntity) {
        return mapper.map(customerEntity, CustomerDto.class);
    }

    public static CustomerEntity convertToEntity(CustomerDto customerDto) {
        return mapper.map(customerDto, CustomerEntity.class);
    }
}
