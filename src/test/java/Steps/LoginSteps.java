package Steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.LoginPage;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends Steps {
    private static WebDriver driver;
    private static WebDriverWait wait;
    @Given("Jestem zalogowany jako admin")
    public void givenIAmLoggedInAsAdmin(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver, 5);
    }
    @Given("Jestem zalogowany jako admin na stronie autorów")
    public void givenIAmLoggedInAsAdminOnAuthorsPage(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver, 5);
        loginPage.authorPage();
    }
    @Given("Jestem wylogowany")
    public void givenIAmLoggedOut(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.get("http://bookcatalog.azurewebsites.net/Account/Login");
    }

    @When("Wyloguje się")
    public void whenLoggingOut(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logOut();
        loginPage.authorPage();
    }
    @Then("Zobaczę przycisk zaloguj")
    public void thenIWillSeeLogInButton(){

        assertNotNull(driver.findElement(By.id("LoginButton")).getText());

    }
    @AfterScenario
    public void cleanup(){
        driver.quit();
    }
}
