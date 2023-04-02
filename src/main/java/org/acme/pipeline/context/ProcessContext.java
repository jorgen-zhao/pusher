package org.acme.pipeline.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.acme.response.BaseResult;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class ProcessContext<T extends ProcessModel>{

    private String code;

    private BaseResult result;

    private T model;

    private Boolean needBreak;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BaseResult getResult() {
        return result;
    }

    public void setResult(BaseResult result) {
        this.result = result;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public Boolean getNeedBreak() {
        return needBreak;
    }

    public void setNeedBreak(Boolean needBreak) {
        this.needBreak = needBreak;
    }
}
