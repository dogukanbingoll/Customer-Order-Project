package com.dogukan.customerorderproject.maping;

import com.dogukan.customerorderproject.dto.CustDto;
import com.dogukan.customerorderproject.entity.CustEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustMapper {

    CustMapper INSTANCE = Mappers.getMapper(CustMapper.class);

    CustEntity toEntity(CustDto custDto);
    List<CustEntity> toEntity(List<CustDto> custDto);
    CustDto  toDto(CustEntity custEntity);
    List<CustDto>  toDto(List<CustEntity> custEntity);



}
