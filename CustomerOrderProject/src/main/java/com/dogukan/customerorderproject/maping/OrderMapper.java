package com.dogukan.customerorderproject.maping;

import com.dogukan.customerorderproject.dto.OrderDto;
import com.dogukan.customerorderproject.entity.OrderEntity;
import org.hibernate.criterion.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE= Mappers.getMapper(OrderMapper.class);

    OrderEntity toEntity(OrderDto orderDto);
    List<OrderEntity> toEntity(List<OrderDto> orderDto);
    OrderDto toDto(OrderEntity orderEntity);
    List<OrderDto> toDto(List<OrderEntity> orderEntity);
}
