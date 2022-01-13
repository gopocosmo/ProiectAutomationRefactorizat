package Base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SharedData {
    public WebDriver driver;

    @Before
    public void setUp(){
        //incarcam locatia driver-ului
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\ChromeDriver\\chromedriver.exe");

        //disable pop-up allow-notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        //deschidem chrome browser
        driver = new ChromeDriver(options);

        //introducem adresa paginii de test ex: reddit.com
        driver.get("https://www.reddit.com/");

        //o facem mare
        driver.manage().window().maximize();

        //adaugam un delay
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
