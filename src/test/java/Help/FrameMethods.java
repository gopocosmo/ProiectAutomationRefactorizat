package Help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {
    public WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

    //facem metoda de a schimba focusul pe iframe de login
    public void switchToIframeLogin(WebElement element){
        driver.switchTo().frame(element);
    }
}
