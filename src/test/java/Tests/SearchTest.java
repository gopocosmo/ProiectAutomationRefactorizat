package Tests;

import Base.SharedData;
import Help.ValidationMethods;
import Pages.HomePage;
import org.junit.Test;

public class SearchTest  extends SharedData {
    public HomePage homePage;
    public ValidationMethods validationMethods;


    //test de search functionality
    @Test
    public void testAutomat(){
        homePage = new HomePage(driver);
        validationMethods = new ValidationMethods(driver);

        homePage.clickSearchBar();
        homePage.searchParameter("The Witcher 3");
        homePage.clickSearchGlass();
        validationMethods.validateUrl("https://reddit.com/");

    }
}
