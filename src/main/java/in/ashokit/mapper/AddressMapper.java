package in.ashokit.mapper;

import in.ashokit.dto.AddressDto;
import in.ashokit.entity.ShippingAddressEntity;
import org.modelmapper.ModelMapper;

public class AddressMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static AddressDto convertToDto(ShippingAddressEntity addrEntity) {
        return mapper.map(addrEntity, AddressDto.class);
    }

    public static ShippingAddressEntity toEntity(AddressDto addrDto) {
        return mapper.map(addrDto, ShippingAddressEntity.class);
    }
}
