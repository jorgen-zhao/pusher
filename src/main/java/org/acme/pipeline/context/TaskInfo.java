package org.acme.pipeline.context;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
//@Builder
@ToString
public class TaskInfo {

    private String templateCode;

    private String sourceCode;

    private String target;

    private String sendChanel;

    private ContentModel contentModel;

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSendChanel() {
        return sendChanel;
    }

    public void setSendChanel(String sendChanel) {
        this.sendChanel = sendChanel;
    }

    public ContentModel getContentModel() {
        return contentModel;
    }

    public void setContentModel(ContentModel contentModel) {
        this.contentModel = contentModel;
    }
}
