
//Testing https://swapi.co/


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwapiTest {
    String driverPath = "C:\\Users\\Glon\\Desktop\\Nowy folder\\Nowy folder\\geckodriver.exe";

//    @Test
//    public void CanWeGetMainGUIPage(){
//        WebDriver driver;
//        System.setProperty("webdriver.gecko.driver", driverPath);
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        driver = new FirefoxDriver(capabilities);
//        driver.get("https://swapi.co/");
//        assertTrue(driver.getTitle().contains("Star Wars"));
//        driver.quit();
//    }
HtmlUnitDriver driver;

    @BeforeEach
    public void Setup(){
     driver=new HtmlUnitDriver();
    }
    @AfterEach
    public void Cleanup(){
        driver.quit();

    }
    @Test
    public void CanWeGetMainGUIPageHeadless(){
        driver.get("https://swapi.co/");
        assertTrue(driver.getTitle().contains("Star Wars"));
    }



    @Test
    public void CanWeGetMainGUIPageHeadlessa(){
//WebDriver driver;
//        // this does actually work on HtmlUnitDriver
//        driver = new HtmlUnitDriver(BrowserVersion.getDefault(), true);
//        ((HtmlUnitDriver)driver).setJavascriptEnabled(true);
////driver = new SafariDriver();
//        driver.get("http://swapi.co/api/people/2/?format=api");
//
//        WebElement response = driver.findElement(By.cssSelector("div.response-info > pre"));
//
//        String json = response.getText();
//
//
//    //    assertThat(json.contains("C-3PO")).isNotEqualTo(false);
//
//        driver.quit();
//
//
//    }









//
//    @Test
//    public void CanWeSearchOnGUIPageHeadless(){ //This test will have double assertion,
//        // first to check if we are on the main page and if the content will change after searching
//        driver= new HtmlUnitDriver(true);
//        ((HtmlUnitDriver)driver).setJavascriptEnabled(true);
//
//        driver.get("https://swapi.co/");
//        WebElement inputfield = driver.findElement(By.id("interactive"));
//
//        inputfield.sendKeys("people/2/");
//
//        driver.findElement(By.className("btn-primary")).click();
//
//        new WebDriverWait(driver, 10).
//                until(
//                        ExpectedConditions.
//                                textToBePresentInElementLocated(By.id("interactive_output"), "C-3PO"));
//
//        WebElement output = driver.findElement(By.id("interactive_output"));
//
//
//        assertTrue(output.getText().contains("C-3PO"));
//
//        driver.quit();
//
//
    }
}
