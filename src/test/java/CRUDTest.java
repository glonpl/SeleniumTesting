import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class CRUDTest {
    private WebDriver driver;
   // String driverPath = "C:\\Users\\Glon\\Desktop\\Nowy folder\\Nowy folder\\geckodriver.exe";
@BeforeEach
public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
}
@AfterEach
public void tearDown() {
    driver.quit();
}
    @Test
    public void CanWeGetMainGUIPageHeadless(){
    //    driver.get("https://swapi.co/");
     //   assertTrue(driver.getTitle().contains("Star Wars"));
    }

    @Test
    public void LoginCorrectTest() {
//        HomePage home = new HomePage(driver);
//        driver.get(home.getWebLink());
//        home.clickLoginButton();
//
//        LoginPage login = new LoginPage(driver);
//        login.logIn(Strings.getEmail(), Strings.getPassword());
//
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().contains("home");
//            }
//        });
//
//        RepositoriesPage repos = new RepositoriesPage(driver);
//        Assert.assertNotEquals(0, repos.numberRepos());
    }
}