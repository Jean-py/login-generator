package dcll;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jp on 15/04/16.
 */
public class LoginGeneratorTest {

    LoginService loginService;
    LoginGenerator loginGenerator;

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);

    }

    @Test
    public void generateLoginForDurandPaul() throws Exception {
        String res;
        res = loginGenerator.generateLoginForNomAndPrenom("Durand","Paul");
        assertEquals(loginService.loginExists(res),true);
        assertEquals(res,"PDUR");


    }

    @Test
    public void generateLoginForRollingJean() throws Exception {
        String res;
        res = loginGenerator.generateLoginForNomAndPrenom("Rolling","Jean");
        assertEquals(loginService.loginExists(res),true);
        assertEquals(res,"JROL1");
    }

    @Test
    public void generateLoginForDurandPaulAccent() throws Exception {
        String res;
        res = loginGenerator.generateLoginForNomAndPrenom("Dùrand","Paul");
        assertEquals(loginService.loginExists(res),true);
        assertEquals(res,"PDUR");
    }

    @Test
    public void generateLoginForPaulDu() throws Exception {
        String res;
        res = loginGenerator.generateLoginForNomAndPrenom("Du","Paul");
        assertEquals(loginService.loginExists(res),true);
        assertEquals(res,"PDU");
    }

    @Test
    public void generateLoginForJohnRalling() throws Exception {
        String res;
        res = loginGenerator.generateLoginForNomAndPrenom("Ralling","John");
        assertEquals(loginService.loginExists(res),true);
        assertEquals(res,"JRAL2");
    }



    

}