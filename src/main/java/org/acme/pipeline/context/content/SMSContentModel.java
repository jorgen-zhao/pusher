package org.acme.pipeline.context.content;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.ToString;
import org.acme.pipeline.context.ContentModel;

//@Data
//@ToString
// second way
//@JsonTypeName("sms")
public class SMSContentModel extends ContentModel {

    private String content;

    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SMSContentModel{" +
                "content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
