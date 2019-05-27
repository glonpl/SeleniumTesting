import Pages.AuthorsPage;
import Pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CRUDTest {
    public WebDriverWait wait;
    private WebDriver driver;
    //  private WebDriver driver2;
    private String nJst="Nie jest";
    private String bZm="Brak zmian";
    public CRUDTest() {
        //  System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //  this.driver2 = new ChromeDriver();

        System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);

        this.driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        // driver2.quit();

    }

    public void loginAdmin(WebDriver drv) {
        LoginPage loginPage = PageFactory.initElements(drv, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        loginPage.authorPage();

    }

    @Test
    public void canWeGetAuthorByIdFF() {
        loginAdmin(driver);
        AuthorsPage authorsPage = PageFactory.initElements(driver, AuthorsPage.class);
        new WebDriverWait(driver, 5);
        assertTrue(authorsPage.getAuthor(2).startsWith("Adam Mickiewicz"));

    }


    @Test
    public void canWeCRUDAuthorAddDeleteFF() {

        loginAdmin(driver);
        new WebDriverWait(driver, 5);
        AuthorsPage authorsPage = PageFactory.initElements(driver, AuthorsPage.class);
        int b4add = authorsPage.howManyAuthors();
        authorsPage.toCreate();
        authorsPage.createAuthor("Adam", "Malysz");
        authorsPage.toAuthors();
        wait.until(ExpectedConditions.titleIs("Authors - BookCatalog"));
        if (b4add + 1 != authorsPage.howManyAuthors()) {
            assertSame("Jest o jednego autora wiecej", nJst, "Add Nie dziala");
        } else {
            authorsPage.deleteLastAuthor();
            wait.until(ExpectedConditions.titleIs("Authors - BookCatalog"));
            if (!(b4add == authorsPage.howManyAuthors())) {
                assertSame("Jest tyle samo autorow co na poczatku", nJst, "Delete Nie dziala");
            }
        }
        if (!authorsPage.getLastAuthor().contains("Ostatni")) {
            assertSame("Ostatni Autor jest na końcu", nJst, "Usunięto za dużo");
        } else {
            assertTrue(true, "CRUD add i delete działają");
        }
    }

    @Test
    public void canWeCRUDAuthorEditFF() {

        loginAdmin(driver);
        new WebDriverWait(driver, 5);
        AuthorsPage authorsPage = PageFactory.initElements(driver, AuthorsPage.class);
        String b4edit = authorsPage.getAuthor(6);
        authorsPage.EditAuthor(17, "Edytowany", "Ziomek");
        wait.until(ExpectedConditions.titleIs("Authors - BookCatalog"));
        if (b4edit.equals(authorsPage.getAuthor(6))) {
            assertSame("Zmiana danych", bZm, "Edit nie działa");
        } else {
            authorsPage.EditAuthor(17, "Podstawowe", "Dane");
            wait.until(ExpectedConditions.titleIs("Authors - BookCatalog"));
            assertTrue(b4edit.startsWith(authorsPage.getAuthor(6)));
        }
    }
}
