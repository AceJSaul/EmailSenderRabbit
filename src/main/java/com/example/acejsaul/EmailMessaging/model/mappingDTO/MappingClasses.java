package com.example.acejsaul.EmailMessaging.model.mappingDTO;

import com.example.acejsaul.EmailMessaging.model.Order;
import com.example.acejsaul.EmailMessaging.model.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MappingClasses {

    MappingClasses INSTANCE = Mappers.getMapper(MappingClasses.class);

    Order dtoToOrder(OrderDTO orderDTO);

    OrderDTO orderToDTO(Order order);
}
