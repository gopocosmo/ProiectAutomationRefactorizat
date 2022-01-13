package Pages;

import Help.ElementMethods;
import Help.FrameMethods;
import Help.ValidationMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;
    public ValidationMethods validationMethods;

    public BasePage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);
        validationMethods = new ValidationMethods(driver);
        PageFactory.initElements(driver,this);
    }
}
