package in.ashokit.mapper;

import in.ashokit.dto.OrderItemDto;
import in.ashokit.entity.OrderItemEntity;
import org.modelmapper.ModelMapper;

public class OrderItemMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static OrderItemDto convertToDto(OrderItemEntity orderItemEntity) {
        return mapper.map(orderItemEntity, OrderItemDto.class);
    }

    public static OrderItemEntity convertToEntity(OrderItemDto orderItemDto) {
        return mapper.map(orderItemDto, OrderItemEntity.class);
    }
}
