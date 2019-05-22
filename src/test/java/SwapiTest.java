
//Testing https://swapi.co/
import com.gargoylesoftware.htmlunit.BrowserVersion;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
public class SwapiTest {
    String driverPath = "C:\\Users\\Glon\\Desktop\\Nowy folder\\Nowy folder\\geckodriver.exe";

    @Test
    public void CanWeGetMainGUIPage(){
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.get("https://swapi.co/");
        assertTrue(driver.getTitle().contains("Star Wars"));
        driver.quit();
    }
    @Test
    public void CanWeGetMainGUIPageHeadless(){
        WebDriver driver;


        driver = new HtmlUnitDriver();
        driver.get("https://swapi.co/");
        assertTrue(driver.getTitle().contains("Star Wars"));
        driver.quit();
    }
}
