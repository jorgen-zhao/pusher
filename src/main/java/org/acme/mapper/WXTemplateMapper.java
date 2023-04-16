package org.acme.mapper;

import org.acme.domain.WXTemplateDto;

import org.acme.entity.WXTemplate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, uses = {TemplateMapper.class})
public interface WXTemplateMapper extends TemplateMapper {
//    @InheritInverseConfiguration
//    WXTemplate toEntity(WXTemplateDto dto);

    WXTemplateDto toDTO(WXTemplate entity);
}