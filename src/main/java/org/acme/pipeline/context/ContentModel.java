package org.acme.pipeline.context;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.acme.pipeline.context.content.SMSContentModel;
import org.acme.pipeline.context.content.WXTemplate;

import java.io.Serializable;

// first way
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SMSContentModel.class, name = "sms"),
        @JsonSubTypes.Type(value = WXTemplate.class, name = "wx")
})

// second way fixme don't use it forever
/*@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "type")*/
public class ContentModel implements Serializable {

}
