package org.acme.service;


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.acme.domain.TemplateDto;
import org.acme.entity.Template;

import java.util.List;

public interface TemplateService {

    List<TemplateDto> pageTemplate();
}
