package org.acme.domain;

import io.quarkus.arc.All;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WXTemplateDto extends TemplateDto {

    public String path;

    public String templateId;

    public String data;

    public String page;
}
