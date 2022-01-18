package com.dogukan.customerorderproject.maping;


import com.dogukan.customerorderproject.dto.ProdDto;
import com.dogukan.customerorderproject.entity.ProdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProdMapper {
    ProdMapper INSTANCE= Mappers.getMapper(ProdMapper.class);
    ProdEntity toEntity(ProdDto prodDto);
    List<ProdEntity> toEntity(List<ProdDto> prodDto);
    ProdDto toDto(ProdEntity prodEntity);
    List<ProdDto> toDto(List<ProdEntity> prodEntity);
}
