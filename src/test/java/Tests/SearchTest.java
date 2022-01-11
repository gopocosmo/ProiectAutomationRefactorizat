package Tests;

import Base.SharedData;
import Pages.HomePage;
import org.junit.Test;

public class SearchTest  extends SharedData {
    public HomePage homePage;


    //test de search functionality
    @Test
    public void testAutomat(){
        homePage = new HomePage(driver);

        homePage.clickSearchBar();
        homePage.searchParameter("The Witcher 3");
        homePage.clickSearchGlass();
    }
}
