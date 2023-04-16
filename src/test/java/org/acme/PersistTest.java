package org.acme;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.entity.Notify;
import org.acme.entity.SMSTemplate;
import org.acme.entity.WXTemplate;
import org.acme.repository.TemplateRepository;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@QuarkusTest
public class PersistTest {

    @Inject
    TemplateRepository templateRepository;

    @Test
    @Transactional
    void testNotifyOperation() {
        Notify notify = new Notify();
        notify.remark = "测试notify";
        notify.title = "notify title";
        notify.sourceCode = "source code1";

        notify.persist();

        // getting a list of all Person entities
        List<Notify> all = Notify.listAll();
        Log.info(all);
    }

    @Test
    @Transactional
    void testTemplate() {
        WXTemplate wxTemplate = new WXTemplate();
        wxTemplate.templateId = "111xxx222";
        wxTemplate.data = "{\"first\":\"{$first}\",\"keyword1\":\"{$keyword1}\",\"remark\":\"{$remark}\"}";
        wxTemplate.page = "/home";
        wxTemplate.path = "/kasd";
        wxTemplate.content = "this is a wx template ";
        wxTemplate.enabled = true;

        SMSTemplate smsTemplate = new SMSTemplate();
        smsTemplate.content = "{\"data\":\"{$data}\"}";
        smsTemplate.data = "{\"data\":\"{$data}\"}";
        smsTemplate.templateCode = "12312";
        smsTemplate.enabled  = true;

        templateRepository.persist(wxTemplate);
        templateRepository.persist(smsTemplate);

    }
}
