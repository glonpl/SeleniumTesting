import Pages.LoginPage;
import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SeleniumExtension.class)
public class SwapiTest {
    private WebDriver driver;
    private WebDriver driver2;
private WebDriverWait wait;
    public SwapiTest() {
        this.driver = new HtmlUnitDriver();
        wait = new WebDriverWait(driver, 10);


        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        this.driver2 = new FirefoxDriver(options);
    }
@BeforeEach
    public void Setup1()throws Exception {
        //  driver.get("http://bookcatalog.azurewebsites.net/Account/Login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn("admin@admin.com","admin1");
        LoginPage loginPage2 = PageFactory.initElements(driver2, LoginPage.class);
        loginPage2.logIn("admin@admin.com","admin1");
    }

    @AfterEach
    public void Cleanup(){
        driver.quit();
driver2.quit();
    }

    @Test
    public void AreWeLoggedInAsAdminHeadless(){
        new WebDriverWait(driver,5);
       assertTrue(driver.findElement(By.id("UserName")).getText().contains("admin"));
    }


    @Test
    public void AreWeLoggedInAsAdminHeadlessFirefox(){

        new WebDriverWait(driver2,5);
        assertTrue(driver2.findElement(By.id("UserName")).getText().contains("admin"));
    }
    @Test
    public void CanWeGetMainGUIPageHeadlessa(){




   }









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
 //   }
}
