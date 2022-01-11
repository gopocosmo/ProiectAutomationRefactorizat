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
    @FindBy(css = "a[class='Z_HUY3BUsGOBOtdmH94ZS _3Wg53T10KuuPmyWOMWsY2F _2iuoyPiKHN3kfOoeIQalDT _10BQ7pjWbeYP63SAPNS8Ts HNozj_dKjQZ59ZsfEegz8 _2nelDm85zKKmuD94NequP0']")
    private WebElement butonSignUpElement;

    //searchbar
    @FindBy(id = "header-search-bar")
    private WebElement searchBarElement;

    //search icon/action(glass)
    @FindBy(css = "span[class='_2aqH0n-kSzFY7HZZ5GL-Jb']")
    private WebElement searchGlassElement;

    //filters
    @FindBy(id = "CountrySort--CountrySortPicker")
    private WebElement filterCountryElement;





    //metode/actiuni
    //click button login
    public void clickButonLogin(){
        elementMethods.clickElement(butonLoginElement);
    }

    //click buton signup
    public void clickButonSignUp(){
        elementMethods.clickElement(butonSignUpElement);
    }

    //click pe search-bar
    public void clickSearchBar(){
        elementMethods.clickElement(searchBarElement);
    }

    //click pe search(action)/glass
    public void clickSearchGlass(){
        elementMethods.clickElement(searchGlassElement);
    }

    //switch to iframe
    public void switchToIframeLogin(){
        frameMethods.switchToIframeLogin(iframeElement);
    }

    //invalid login
    public void invalidLogin(String username, String parola, String mesaj){
        elementMethods.fillElement(loginUsernameElement, username);
        elementMethods.fillElement(loginPasswordElement, parola);
        elementMethods.clickElement(submitButtonElement);
        validationMethods.validateElementMessage(errorMessageElement, mesaj);
    }

    //search functionality/parameters
    public void searchParameter(String valoare){
        elementMethods.fillElement(searchBarElement, valoare);
        validationMethods.validateElementUrl();
    }


}