package org.acme.domain;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateDto {

    private UUID uuid;

    public String content;

    public boolean enabled;
}
