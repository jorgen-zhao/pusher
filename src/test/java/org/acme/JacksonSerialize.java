package org.acme;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.pipeline.context.ContentModel;
import org.acme.pipeline.context.TaskInfo;
import org.acme.pipeline.context.content.SMSContentModel;
import org.acme.pipeline.context.content.WXTemplate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@QuarkusTest
public class JacksonSerialize {

    @Test
    void testSerialize() throws JsonProcessingException {
        List<TaskInfo> taskInfoList = new ArrayList<>();

        SMSContentModel smsContentModel = new SMSContentModel();
        smsContentModel.setContent("this is sms content model");

        // {"first":"a","keyword1":"a","keyword2":"a","remark":"a"}
        // "{\"first\":\"a\",\"keyword1\":\"a\",\"keyword2\":\"a\",\"remark\":\"a\"}"
        WXTemplate template = new WXTemplate();
        String content = "{\"first\":\"a\",\"keyword1\":\"a\",\"keyword2\":\"a\",\"remark\":\"a\"}";
        template.setContent(content);
        template.setTemplateId("121312");
        template.setPath("123");

        TaskInfo info1 = new TaskInfo();
        info1.setSourceCode("source1");
        info1.setTarget("target1");
        info1.setContentModel(smsContentModel);

        TaskInfo info2 = new TaskInfo();
        info2.setSourceCode("source2");
        info2.setTarget("target2");
        info2.setContentModel(template);

        taskInfoList.add(info1);
        taskInfoList.add(info2);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(taskInfoList);
        System.out.println("writeValueAsString ===> " + json);

        List<TaskInfo> deList = mapper.readValue(json, new TypeReference<>() {
        });
        for (TaskInfo info : deList) {
            System.out.println(info);
        }
        TaskInfo info = deList.get(0);
        TaskInfo info3 = deList.get(1);
        WXTemplate contentModel = (WXTemplate) info3.getContentModel();
        String modelContent = contentModel.getContent();
        Map<String, String> wxMap = mapper.readValue(modelContent, new TypeReference<>() {        });
        System.out.println(wxMap);
        wxMap.forEach((k, v) -> System.out.println(k + " <---> " + v));
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"templateCode\":\"1\",\"sourceCode\":\"1\",\"target\":\"1\",\"sendChanel\":\"wx\",\"contentModel\":{\"type\":\"wx\",\"content\":\"a\",\"url\":\"b\",\"templateId\":\"c\"}}";
        TaskInfo task = mapper.readValue(json, TaskInfo.class);
        if (task.getContentModel() instanceof WXTemplate) {
            WXTemplate wxTemplate = (WXTemplate) task.getContentModel();
            Map<String, String> wxMap = mapper.readValue(wxTemplate.getContent(), new TypeReference<Map<String, String>>() {
            });
            System.out.println(wxMap);
        }
    }
}
