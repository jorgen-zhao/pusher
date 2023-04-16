package org.acme.mapper;

import org.acme.domain.TemplateDto;
import org.acme.entity.Template;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import javax.enterprise.context.ApplicationScoped;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface TemplateMapper {
    TemplateMapper INSTANCE = Mappers.getMapper(TemplateMapper.class);

//    @Mapping(target = "createTime", ignore = true)
//    @Mapping(target = "updateTime", ignore = true)
//    @Mapping(target = "createUser", ignore = true)
//    @Mapping(target = "updateUser", ignore = true)
    TemplateDto toDTO(Template entity);
}
