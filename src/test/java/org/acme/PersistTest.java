package org.acme;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.entity.Notify;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.List;

@QuarkusTest
public class PersistTest {

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
}
