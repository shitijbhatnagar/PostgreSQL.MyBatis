package com.sb.mybatis.postgre.mapper;

import com.sb.mybatis.postgre.dto.ReferralDTO;
import com.sb.mybatis.postgre.model.Referral;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//This is a MapStruct Mapper interface (do not confuse with @Mapper of MyBatis)
//MapStruct creates an implmentation of this interface at compile time by the name ReferralEntityDTOMapperImpl (in target classes)
@Mapper
public interface ReferralEntityDTOMapper {
    ReferralEntityDTOMapper INSTANCE = Mappers.getMapper(ReferralEntityDTOMapper.class);

    @Mapping(source = "givenName", target = "name")
    Referral dtoToEntity(ReferralDTO dto);

    @Mapping(source = "name", target = "givenName")
    ReferralDTO entityToDto(Referral entity);
}