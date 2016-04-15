package dcll;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )    {
        String[] tabString = new String[10];
        String test;
        tabString[0] = "Toto";
        tabString[1] = "JeanPhi";
        tabString[2] = "Dupont";

        LoginService loginService = new LoginService(tabString);
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        test = loginGenerator.generateLoginForNomAndPrenom("Dupond" , "Michel");
        System.out.println("test : "+ test);


    }
}
