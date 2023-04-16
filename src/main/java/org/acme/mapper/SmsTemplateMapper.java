package org.acme.mapper;

import org.acme.domain.SMSTemplateDto;
import org.acme.entity.SMSTemplate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import javax.enterprise.context.ApplicationScoped;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, uses = {TemplateMapper.class})
public interface SmsTemplateMapper extends TemplateMapper {
//    @InheritInverseConfiguration
//    SMSTemplate toEntity(SMSTemplateDto dto);

    SMSTemplateDto toDTO(SMSTemplate entity);
}