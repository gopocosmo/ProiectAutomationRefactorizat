package Help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementMethods {
    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    //facem metoda de "click" pe ceva
    public void clickElement(WebElement element){
        element.click();
    }

    //facem metoda de "send keys" intr-o casuta
    public void fillElement(WebElement element,String valoare){
        element.sendKeys(valoare);
    }

    //facem o metoda de cautare a unui string intr-o lista
    public void findTara(List<WebElement> listElement, String valoare) {
        for (WebElement webElement : listElement) {
            if (webElement.getText().equals(valoare)) {
                webElement.click();
                break;
            }
        }


    }
}
