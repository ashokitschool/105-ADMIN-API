package in.ashokit.mapper;

import in.ashokit.dto.OrderDto;
import in.ashokit.entity.OrderEntity;
import org.modelmapper.ModelMapper;

public class OrderMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static OrderDto convertToDto(OrderEntity orderEntity) {
        return mapper.map(orderEntity, OrderDto.class);
    }

    public static OrderEntity convertToEntity(OrderDto orderDto) {
        return mapper.map(orderDto, OrderEntity.class);
    }
}
