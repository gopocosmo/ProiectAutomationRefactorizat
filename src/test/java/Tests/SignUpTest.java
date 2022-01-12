package Tests;

import Base.SharedData;
import Pages.HomePage;
import org.junit.Test;

public class SignUpTest extends SharedData {
    public HomePage homePage;

    //test de invalid signup, este un "captcha box" care ne impiedica sa efectuam testul cu succes
    @Test
    public void testAutomat(){
        homePage = new HomePage(driver);

        homePage.clickButonSignUp();
        homePage.switchToIframe();
        homePage.invalidRegister("ceva@ceva.com", "mirel221033399", "par@#ola1112");
    }
}
