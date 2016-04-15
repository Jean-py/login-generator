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
    public void generateLoginForNomAndPrenom() throws Exception {
        String res;
        res = loginGenerator.generateLoginForNomAndPrenom("Paul","Durand");

        assertEquals(loginService.loginExists(res),true);
        res = loginGenerator.generateLoginForNomAndPrenom("Jean","Rolling");
        assertEquals(loginService.loginExists(res),true);

        res = loginGenerator.generateLoginForNomAndPrenom("Paul","Dùrand");
        assertEquals(loginService.loginExists(res),true);



    }

}