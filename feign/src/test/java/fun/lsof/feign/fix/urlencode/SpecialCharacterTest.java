package fun.lsof.feign.fix.urlencode;


import fun.lsof.feign.controller.InitiatorController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpecialCharacterTest {

    @Autowired
    InitiatorController initiator;

    @Test
    public void url() {

        String sc = "!*'();:@&=+$,/?#[] ";

        HashMap hashMap = new HashMap();
        hashMap.put("field", sc);

        assertEquals("be +", "{\"field\":\""+sc+"\"}", initiator.post2body4map(hashMap));

        assertEquals("be +", sc, initiator.post2body(sc));
        assertEquals("be +", sc, initiator.post2query(sc));
        assertEquals("be +", sc, initiator.get2query(sc));


        String sc2 = "~!@#$%^&*()`-={}|[]:\";',./<>? ";
        hashMap.clear();
        hashMap.put("field", sc2);
        assertEquals("be +", "{\"field\":\"~!@#$%^&*()`-={}|[]:\\\";',./<>? \"}", initiator.post2body4map(hashMap));

        assertEquals("be +", sc2, initiator.post2body(sc2));
        assertEquals("be +", sc2, initiator.post2query(sc2));
        assertEquals("be +", sc2, initiator.get2query(sc2));

        assertEquals("be +", sc2, initiator.post2form(sc2));
    }

}
