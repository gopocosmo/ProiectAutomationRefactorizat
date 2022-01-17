package Tests;

import Base.SharedData;
import Help.ValidationMethods;
import Pages.HomePage;
import org.junit.Test;

public class FilterTest extends SharedData {
    public HomePage homePage;
    public ValidationMethods validationMethods;

    //test filtre cu tara
    @Test
    public void testAutomat(){
        homePage = new HomePage(driver);
        validationMethods = new ValidationMethods(driver);

        homePage.clickCountryFilter();
        homePage.introducereTara("Canada");
        validationMethods.validateUrl("https://reddit.com/");

    }
}
