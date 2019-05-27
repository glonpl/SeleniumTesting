package Steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.LoginPage;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends Steps {
    private static WebDriver driver;
    private static WebDriverWait wait;
    @Given("Jestem zalogowany jako admin")
    public void givenIAmLoggedInAsAdmin(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver, 5);
    }
    @Given("Jestem zalogowany jako admin na stronie autorów")
    public void givenIAmLoggedInAsAdminOnAuthorsPage(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver, 5);
        loginPage.authorPage();
    }
    @Given("Jestem wylogowany")
    public void givenIAmLoggedOut(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.get("http://bookcatalog.azurewebsites.net/Account/Login");
    }
    @When("Spróbuję się zalogować danymi <login> <password>")
    public void SignInDataTest(@Named("login") String login, @Named("password") String password) throws Exception{

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Email")).clear();
        driver.get("http://bookcatalog.azurewebsites.net/Account/Login");
        new WebDriverWait(driver, 30);
        loginPage.logIn(login, password);
    }

    @When("Wyloguje się")
    public void whenLoggingOut(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.logOut();
       wait.until(ExpectedConditions.elementToBeClickable(By.id("BooksButton")));

        loginPage.authorPage();
    }

    @Then("Zobaczę mój login <message>")
    public void thenIWillSeeMyLogin(@Named("message") String login) throws Exception{
        wait.until(ExpectedConditions.elementToBeClickable(By.id("UserName")));
     //  System.out.print(driver.findElement(By.name("username")).getText());
assertTrue(driver.findElement(By.id("UserName")).getText().endsWith(login));
        driver.quit();
    }

    @Then("Zobaczę komunikat o błędzie")
    public void thenIWillSeeErrorLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("BooksLink")));
       assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/section/form/div[1]/ul/li")).getText().contains("Invalid"));
        driver.quit();
    }
    @Then("Zobaczę przycisk zaloguj")
    public void thenIWillSeeLogInButton(){

        new WebDriverWait(driver, 5);
        assertNotNull(driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li[2]/a")).getText());

    }
    @When("spróbuję wejść na stronę")
    public void whenIWillTryToEnterMain(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("BooksLink")));
        driver.findElement(By.xpath("/html/body/nav/div/div[1]/a")).click();

    }
    @Then("Zobaczę tytuł strony głównej")
    public void thenIWillSeeMainTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("BooksLink")));
   assertTrue(driver.getTitle().contains("Home Page"));

    }
    @AfterScenario
    public void cleanup(){
        driver.quit();
    }
}
