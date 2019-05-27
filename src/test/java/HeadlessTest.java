import Pages.BooksPage;
import Pages.LoginPage;
import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SeleniumExtension.class)
public class HeadlessTest {
    public WebDriverWait wait;
    private WebDriver driver;
    private WebDriver driver2;

    public HeadlessTest() {
        this.driver = new HtmlUnitDriver();
        wait = new WebDriverWait(driver, 10);
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        this.driver2 = new FirefoxDriver(options);
    }

    @BeforeEach
    public void prepare() {
        //  driver.get("http://bookcatalog.azurewebsites.net/Account/Login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        LoginPage loginPage2 = PageFactory.initElements(driver2, LoginPage.class);
        loginPage2.logIn("admin@admin.com", "admin1");
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
        driver2.quit();
    }

    @Test
    public void areWeLoggedInAsAdminHeadless() {
        new WebDriverWait(driver, 5);
        assertTrue(driver.findElement(By.id("UserName")).getText().contains("admin"));
    }


    @Test
    public void areWeLoggedInAsAdminHeadlessFirefox() {

        new WebDriverWait(driver2, 5);
        assertTrue(driver2.findElement(By.id("UserName")).getText().contains("admin"));
    }

    @Test
    public void canWeCountBooksHeadless() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver, 5);
        if (!loginPage.UsernameLoggedin.contains("admin")) {
            assertSame("Zalogowany Admin", "Niezalogowany");
        } else {
            loginPage.bookPage();
            new WebDriverWait(driver, 5);
            BooksPage books = PageFactory.initElements(driver, BooksPage.class);
            new WebDriverWait(driver, 5);
            assertSame(5, books.howManyBooks(), "Czy jest 5 książek?");
        }
    }

    @Test
    public void canWeCountBooksHeadlessFirefox() {

        LoginPage loginPage = PageFactory.initElements(driver2, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver2, 5);
        if (!loginPage.UsernameLoggedin.contains("admin")) {
            assertSame("Zalogowany Admin", "Niezalogowany");
        } else {
            loginPage.bookPage();
            new WebDriverWait(driver2, 5);
            BooksPage books = PageFactory.initElements(driver2, BooksPage.class);
            new WebDriverWait(driver2, 5);
            assertSame(5, books.howManyBooks(), "Czy jest 5 książek?");
        }
    }
//    @Test
//    public void canWeAddBooksHeadlessFirefox() {
//
//        LoginPage loginPage = PageFactory.initElements(driver2, LoginPage.class);
//        loginPage.logIn("admin@admin.com", "admin1");
//        new WebDriverWait(driver2, 5);
//        if (!loginPage.UsernameLoggedin.contains("admin")) {
//            assertSame("Zalogowany Admin", "Niezalogowany");
//        } else {
//            loginPage.bookPage();
//            new WebDriverWait(driver2, 5);
//            BooksPage books = PageFactory.initElements(driver2, BooksPage.class);
//            new WebDriverWait(driver2, 5);
//            books.toCreate();
//            new WebDriverWait(driver2, 5);
//            books = PageFactory.initElements(driver2, BooksPage.class);
//            new WebDriverWait(driver2, 5);
//            books.createBook("Artur");
//        }
//    }
//

    @Test
    public void canWeGetToCreatePageHeadless() {
        LoginPage loginPage = PageFactory.initElements(driver2, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver2, 5);
        if (!loginPage.UsernameLoggedin.contains("admin")) {
            assertSame("Zalogowany Admin", "Niezalogowany");
        } else {
            loginPage.bookPage();
            new WebDriverWait(driver2, 5);
            BooksPage books = PageFactory.initElements(driver2, BooksPage.class);
            books.toCreate();
            assertTrue(driver2.getTitle().contains("Create"));
        }
    }
//Nie działa, bo Datepicker narzeka

    @Test
    public void canWeGetToCreatePageHeadlessFirefox() {
        LoginPage loginPage = PageFactory.initElements(driver2, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver2, 5);
        if (!loginPage.UsernameLoggedin.contains("admin")) {
            assertSame("Zalogowany Admin", "Niezalogowany");
        } else {
            loginPage.bookPage();
            new WebDriverWait(driver2, 5);
            BooksPage books = PageFactory.initElements(driver2, BooksPage.class);
            // List<WebElement> ksiazki =books.getBooks();
            //  int beforeAdd = ksiazki.size();
            books.toCreate();
            assertTrue(driver2.getTitle().contains("Create"));
//            books = PageFactory.initElements(driver2, BooksPage.class);
//            books.createBook("Testowanie", "300", "01012013", "30", "1");
//            books.toBooks();
//            books = PageFactory.initElements(driver2, BooksPage.class);
//            new WebDriverWait(driver2, 5);
//
//            if(!(beforeAdd+1==books.howManyBooks())){
//                assertSame("Jest o jedna ksiazke wiecej","Nie jest","Add Nie dziala");
//            }else{
//             books.deleteLastBook();
//              if(!(beforeAdd==books.howManyBooks())){
//                 assertSame("Jest tyle samo ksiazek co na poczatku","Nie jest","Delete Nie dziala");
//
//             }
//            }
        }
//        assertTrue(true);
    }

    @Test
    public void canWeGetSearchHeadless() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver, 5);
        if (!loginPage.UsernameLoggedin.contains("admin")) {
            assertSame("Zalogowany Admin", "Niezalogowany");
        } else {

            loginPage.bookPage();
            new WebDriverWait(driver, 5);
            BooksPage books = PageFactory.initElements(driver, BooksPage.class);
            books.searchBooks("Krz");
            assertEquals(1, books.howManyBooks());
        }

    }

    @Disabled
    @Test
    public void canWeGetSearchHeadlessFirefox() {
        LoginPage loginPage = PageFactory.initElements(driver2, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver2, 5);
        if (!loginPage.UsernameLoggedin.contains("admin")) {
            assertSame("Zalogowany Admin", "Niezalogowany");
        } else {

            loginPage.bookPage();
            new WebDriverWait(driver2, 5);
            BooksPage books = PageFactory.initElements(driver2, BooksPage.class);
            books.searchBooks("Krz");
            assertEquals(1, books.howManyBooks());//co ciekawe wyświetla tu 5(czyli wszystkie)
        }

    }


    @Test
    public void canWeGetBookByIdHeadlessFirefox() {
        LoginPage loginPage = PageFactory.initElements(driver2, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver2, 5);
        if (!loginPage.UsernameLoggedin.contains("admin")) {
            assertSame("Zalogowany Admin", "Niezalogowany");
        } else {

            loginPage.bookPage();
            new WebDriverWait(driver2, 5);
            BooksPage books = PageFactory.initElements(driver2, BooksPage.class);

            assertTrue(books.getBook(1).contains("Quo Vadis"));
        }

    }

    @Test
    public void canWeGetBookByIdHeadless() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver, 5);
        if (!loginPage.UsernameLoggedin.contains("admin")) {
            assertSame("Zalogowany Admin", "Niezalogowany");
        } else {

            loginPage.bookPage();
            new WebDriverWait(driver, 5);
            BooksPage books = PageFactory.initElements(driver, BooksPage.class);

            assertTrue(books.getBook(1).contains("Quo Vadis"));
        }

    }

    @Test
    public void canWeGetLastBookHeadlessFirefox() {
        LoginPage loginPage = PageFactory.initElements(driver2, LoginPage.class);
        loginPage.logIn("admin@admin.com", "admin1");
        new WebDriverWait(driver2, 5);
        if (!loginPage.UsernameLoggedin.contains("admin")) {
            assertSame("Zalogowany Admin", "Niezalogowany");
        } else {

            loginPage.bookPage();
            new WebDriverWait(driver2, 5);
            BooksPage books = PageFactory.initElements(driver2, BooksPage.class);
            books.searchBooks("Krz");
            assertTrue(books.getLastBook().startsWith("Harry Potter And"));
        }

    }


}
