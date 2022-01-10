package Pages;

import Help.ElementMethods;
import Help.FrameMethods;
import Help.ValidationMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class HomePage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;
    public ValidationMethods validationMethods;


    public HomePage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);
        validationMethods = new ValidationMethods(driver);
        PageFactory.initElements(driver,this);
    }

    //login button
    @FindBy(css = "a[class='_3Wg53T10KuuPmyWOMWsY2F _2iuoyPiKHN3kfOoeIQalDT _2tU8R9NTqhvBrhoNAXWWcP HNozj_dKjQZ59ZsfEegz8 _2nelDm85zKKmuD94NequP0']")
    private WebElement butonLoginElement;

    //iframe de login
    @FindBy(xpath = "//iframe[@class='_25r3t_lrPF3M6zD2YkWvZU']")
    private WebElement iframeElement;

    //de aici in jos actiunea se petrece inauntru in iframe
    //username filed
    @FindBy(id = "loginUsername")
    private WebElement loginUsernameElement;

    //parola field
    @FindBy(id = "loginPassword")
    private  WebElement loginPasswordElement;

    //buton de login/submit
    @FindBy(css = ".m-small-margin button[type='submit']")
    private WebElement submitButtonElement;

    //mesaj de eroare
    @FindBy(xpath = "//div[contains(text(),'Incorrect username or password')]")
    private WebElement errorMessageElement;

    //signup button
    //searchbar
    //filters

    //click button login
    public void clickButonLogin(){
        elementMethods.clickElement(butonLoginElement);
    }

    public void switchToIframeLogin(){
        frameMethods.switchToIframeLogin(iframeElement);
    }

    public void invalidLogin(String username, String parola, String mesaj){
        elementMethods.fillElement(loginUsernameElement, username);
        elementMethods.fillElement(loginPasswordElement, parola);
        elementMethods.clickElement(submitButtonElement);
        validationMethods.validateElementMessage(errorMessageElement, mesaj);
    }

    //click buton signup
}
