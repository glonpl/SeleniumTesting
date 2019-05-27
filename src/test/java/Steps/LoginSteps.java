package Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends Steps {
    private static WebDriver driver;
    private static WebDriverWait wait;
    @Given("Jestem zalogowany jako admin")
    public void givenIAmLoggedInAsAdmin(){
        System.setProperty("webdriver.geckordriver.driver", "resources/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver, 5);
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
}
