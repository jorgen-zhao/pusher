package org.acme.service.impl;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.logging.Log;
import io.quarkus.panache.common.Page;
import org.acme.domain.TemplateDto;
import org.acme.entity.Template;
import org.acme.mapper.TemplateMapper;
import org.acme.repository.TemplateRepository;
import org.acme.service.TemplateService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TemplateServiceImpl implements TemplateService {

    @Inject
    TemplateRepository templateRepository;

    @Inject
    TemplateMapper templateMapper;

    @Override
    public List<TemplateDto> pageTemplate() {
        List<Template> list = templateRepository.listAll();
        List<TemplateDto> collect = templateRepository.findAll().stream().map(templateMapper::toDTO).collect(Collectors.toList());
        Log.infov("{0}", collect);
        return collect;
    }
}
