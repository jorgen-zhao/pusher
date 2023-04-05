package org.acme.pipeline.context.content;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Data;
import org.acme.pipeline.context.ContentModel;

import java.util.Map;

//@Data
//@Builder

// second way
//@JsonTypeName("wx")
public class WXTemplate extends ContentModel {

    /**
     * 模板消息发送的数据
     */
    private String content;

    /**
     * 模板消息跳转的url
     */
    private String url;

    /**
     * 模板Id
     */
    private String templateId;

    /**
     * 模板消息跳转小程序的appid
     */
    private String miniProgramId;

    /**
     * 模板消息跳转小程序的页面路径
     */
    private String path;


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

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getMiniProgramId() {
        return miniProgramId;
    }

    public void setMiniProgramId(String miniProgramId) {
        this.miniProgramId = miniProgramId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "WXTemplate{" +
                "content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", templateId='" + templateId + '\'' +
                ", miniProgramId='" + miniProgramId + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
