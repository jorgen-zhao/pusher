package org.acme.pipeline.context;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class SendTaskModel implements ProcessModel{

   private String templateCode;

   private Map<String, String> data;

   private String sourceCode;

   private String target;

   private List<TaskInfo> taskInfos;
}
