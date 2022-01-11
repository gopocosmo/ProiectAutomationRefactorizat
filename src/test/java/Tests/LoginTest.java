package Tests;

import Base.SharedData;
import Pages.HomePage;
import org.junit.Test;

public class LoginTest extends SharedData {
    public HomePage homePage;

    //test de ivalid login(username si parola gresite)
    @Test
    public void testAutomat(){
        homePage = new HomePage(driver);

        homePage.clickButonLogin();
        homePage.switchToIframeLogin();
        homePage.invalidLogin("adi","parola1112","Incorrect username or password");
    }
}
