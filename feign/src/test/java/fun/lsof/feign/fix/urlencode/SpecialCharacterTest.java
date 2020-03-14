package fun.lsof.feign.fix.urlencode;


import fun.lsof.feign.controller.InitiatorController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpecialCharacterTest {

    @Autowired
    InitiatorController initiator;

    @Test
    public void plusSign() {

        assertEquals("be +", "{1111+}", initiator.post2body("{1111+}"));
        assertEquals("be +", "+", initiator.post2query("+"));
        assertEquals("be +", "+", initiator.get2query("+"));

    }


}
