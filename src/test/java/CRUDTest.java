import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CRUDTest {
    String driverPath = "C:\\Users\\Glon\\Desktop\\Nowy folder\\Nowy folder\\geckodriver.exe";

    @Test
    public void CanWeGetMainGUIPageHeadless(){
    //    driver.get("https://swapi.co/");
     //   assertTrue(driver.getTitle().contains("Star Wars"));
    }
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
}
