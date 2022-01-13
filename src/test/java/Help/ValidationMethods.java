package Help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidationMethods {
    public WebDriver driver;

    public ValidationMethods(WebDriver driver) {
        this.driver = driver;
    }

    //facem metoda de verificare/validare prin mesaj expus pe pagina
    public void validateElementMessage(WebElement element, String valoare){
        String actualError = element.getText();
        Assert.assertEquals("MESAJUL NU ESTE CORECTTTTTTTTT", valoare, actualError);
    }

    //facem metoda de verificare/validare prin verificarea schimbarii url-ului
    public void validateUrl(String expected){
        String newUrl = driver.getCurrentUrl();
        Assert.assertNotEquals("EROAREEEEEEEEEEEEEEEEEEEEEEEEEEE",expected, newUrl);
    }

    public void validateTitlePage(String expected){
        String actualUrl = driver.getTitle();
        Assert.assertEquals(expected,actualUrl);
    }
}
