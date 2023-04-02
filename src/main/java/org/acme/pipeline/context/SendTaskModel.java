package org.acme.pipeline.context;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

//@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SendTaskModel implements ProcessModel{

   private String templateCode;

   private Map<String, String> data;

   private String sourceCode;

   private String target;

   private List<TaskInfo> taskInfos;


   public String getTemplateCode() {
      return templateCode;
   }

   public void setTemplateCode(String templateCode) {
      this.templateCode = templateCode;
   }

   public Map<String, String> getData() {
      return data;
   }

   public void setData(Map<String, String> data) {
      this.data = data;
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

   public List<TaskInfo> getTaskInfos() {
      return taskInfos;
   }

   public void setTaskInfos(List<TaskInfo> taskInfos) {
      this.taskInfos = taskInfos;
   }
}
