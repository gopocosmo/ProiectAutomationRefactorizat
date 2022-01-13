package Tests;

import Base.SharedData;
import Pages.HomePage;
import org.junit.Test;

public class FilterTest extends SharedData {
    public HomePage homePage;

    //test filtre cu tara
    @Test
    public void testAutomat(){
        homePage = new HomePage(driver);

        homePage.clickCountryFilter();
        homePage.introducereTara("Canada");

        //tre sa validezi ca s-a modificat pe Canada
    }
}
