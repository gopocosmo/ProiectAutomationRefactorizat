package Help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidationMethods {
    WebDriver driver;

    public ValidationMethods(WebDriver driver) {
        this.driver = driver;
    }

    //facem metoda de verificare/validare prin mesaj expus pe pagina
    public void validateElementMessage(WebElement element, String valoare){
        String actualError = element.getText();
        Assert.assertEquals("MESAJUL NU ESTE CORECTTTTTTTTT", valoare, actualError);
    }

    //facem metoda de verificare/validare prin verificarea schimbarii url-ului
    public void validateElementUrl(WebElement element, String valoare){
        String actualUrl = "https://www.reddit.com/";
        String newUrl = driver.getCurrentUrl();
        Assert.assertNotEquals("EROAREEEEEEEEEEEEEEEEEEEEEEEEEEE",actualUrl,newUrl);
    }
}
