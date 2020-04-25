package com.offlinepay.merchant.mapper;

import com.offlinepay.merchant.entity.MerchantEntity;
import com.offlinepay.merchant.model.MerchantDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MerchantMapper {

    MerchantMapper INSTANCE = Mappers.getMapper(MerchantMapper.class);

    MerchantDto ToMerchantDto(MerchantEntity merchantEntity);

    @InheritInverseConfiguration
    MerchantEntity toMerchantEntity(MerchantDto merchantDto);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    Iterable<MerchantDto> toMerchantDtoList(Iterable<MerchantEntity> merchantEntityIterable);

}