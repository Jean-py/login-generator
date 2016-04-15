package dcll;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jp on 15/04/16.
 */
public class LoginServiceTest {
    private LoginService loginService;


    @Before
    public void setUp(){
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
    }



    @Test
    public void loginExists() throws Exception {
        Boolean res = loginService.loginExists("JROL");
        assertEquals(res, true);
    }

    @Test
    public void loginDoesntExists() throws Exception {
        Boolean res = loginService.loginExists("AAAAA");
        assertEquals(res, false);
    }

    @Test
    public void addLogin() throws Exception {
        String test = "JRAL2";
        this.loginService.addLogin(test);
        List myListe = new ArrayList<String>();
        myListe = this.loginService.findAllLogins();
        assertEquals(myListe.contains(test), true);
    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {
        List<String> myListe = new ArrayList<String>();
        myListe = this.loginService.findAllLoginsStartingWith("J");
        assertEquals(myListe.size(), 4);
        assertEquals(myListe.contains("JROL"),true);
        assertEquals(myListe.contains("JDUP"),true);
        assertEquals(myListe.contains("JRAL"),true);
        assertEquals(myListe.contains("JRAL1"),true);
    }

    @Test
    public void findAllLogins() throws Exception {
        List<String> myListe = new ArrayList<String>();
        myListe = this.loginService.findAllLogins();
        assertEquals(myListe.size(),6);
    }


}