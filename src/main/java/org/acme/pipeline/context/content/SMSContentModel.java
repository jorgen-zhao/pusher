package org.acme.pipeline.context.content;

import lombok.Data;
import lombok.ToString;
import org.acme.pipeline.context.ContentModel;

@Data
@ToString

public class SMSContentModel extends ContentModel {

    private String content;

    private String url;
}
