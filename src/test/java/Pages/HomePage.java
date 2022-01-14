package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
        validationMethods.validateTitlePage("Reddit - Dive into anything");
        acceptCookies();
    }

    //iframe
    @FindBy(xpath = "//iframe[@class='_25r3t_lrPF3M6zD2YkWvZU']")
    private WebElement iframeElement;
    @FindBy(xpath = "//button[contains(text(),'Accept all')]")
    private WebElement acceptCookieElement;

    //login elements
    //login button
    @FindBy(css = "a[class='_3Wg53T10KuuPmyWOMWsY2F _2iuoyPiKHN3kfOoeIQalDT _2tU8R9NTqhvBrhoNAXWWcP HNozj_dKjQZ59ZsfEegz8 _2nelDm85zKKmuD94NequP0']")
    private WebElement butonLoginElement;
    //login username filed
    @FindBy(id = "loginUsername")
    private WebElement loginUsernameElement;
    //login parola field
    @FindBy(id = "loginPassword")
    private  WebElement loginPasswordElement;
    //buton de login/submit
    @FindBy(css = ".m-small-margin button[type='submit']")
    private WebElement submitButtonElement;
    //mesaj de eroare
    @FindBy(xpath = "//div[contains(text(),'Incorrect username or password')]")
    private WebElement errorMessageElement;

    //signup elements
    //signup button
    @FindBy(css = "a[class='Z_HUY3BUsGOBOtdmH94ZS _3Wg53T10KuuPmyWOMWsY2F _2iuoyPiKHN3kfOoeIQalDT _10BQ7pjWbeYP63SAPNS8Ts HNozj_dKjQZ59ZsfEegz8 _2nelDm85zKKmuD94NequP0']")
    private WebElement butonSignUpElement;
    @FindBy(xpath = "//iframe[@class='_25r3t_lrPF3M6zD2YkWvZU']")
    private WebElement iframeEmailElement;
    //registration email filed
    @FindBy(id = "regEmail")
    private WebElement signUpEmailElement;
    //buton de continue
    @FindBy(css = "button[data-step='email']")
    private WebElement continueButtonElement;
    //signup username field
    @FindBy(id = "regUsername")
    private WebElement signUpUsernameElement;
    //signup parola field
    @FindBy(id = "regPassword")
    private WebElement signUpPasswordElement;
    //buton confirmare signup
    @FindBy(css = "button[data-step='username-and-password']")
    private WebElement confirmSignUpButtonElement;

    //search elements
    //searchbar
    @FindBy(id = "header-search-bar")
    private WebElement searchBarElement;
    //search icon/action(glass)
    @FindBy(css = "span[class='_2aqH0n-kSzFY7HZZ5GL-Jb']")
    private WebElement searchGlassElement;

    //filter elements
    //country filter
    @FindBy(id = "CountrySort--CountrySortPicker")
    private WebElement filterCountryElement;
    //filtru lista cu tari
    @FindBy(css = "button[class='_10K5i7NW6qcm-UoCtpB3aK _3LwUIE7yX7CZQKmD2L87vf _3LjUrsRA9MkUFLGB6ZCWaX _1oYEKCssGFjqxQ9jJMNj5G']")
    private List<WebElement> listaCuTari;


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

    //click pe filtru de tari
    public void clickCountryFilter(){
        elementMethods.clickElement(filterCountryElement);
    }

    //switch to iframe
    public void switchToIframe(){
        frameMethods.switchToIframeLogin(iframeElement);
    }

    public void acceptCookies(){
        elementMethods.clickElement(acceptCookieElement);
    }

    //invalid login
    public void invalidLogin(String username, String parola, String mesaj){
        elementMethods.fillElement(loginUsernameElement, username);
        elementMethods.fillElement(loginPasswordElement, parola);
        elementMethods.clickElement(submitButtonElement);
        waitError(errorMessageElement);
        validationMethods.validateElementMessage(errorMessageElement, mesaj);
    }

    //search functionality/parameters
    public void searchParameter(String valoare){
        elementMethods.fillElement(searchBarElement, valoare);
        validationMethods.validateUrl("https://reddit.com/");
    }

    //aplicare filtru "tara" in lista
    public void introducereTara(String valoare){
        elementMethods.findTara(listaCuTari, valoare);
        validationMethods.validateUrl("https://reddit.com/");
    }

    //invalid register
    public void invalidRegister(String email, String username, String parola){
        elementMethods.fillElement(signUpEmailElement, email);
        elementMethods.clickElement(continueButtonElement);
        elementMethods.fillElement(signUpUsernameElement, username);
        elementMethods.fillElement(signUpPasswordElement, parola);
        elementMethods.scrollIntoViewElement(confirmSignUpButtonElement);
        elementMethods.clickElement(confirmSignUpButtonElement);
    }

    public void waitError(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
    }
}