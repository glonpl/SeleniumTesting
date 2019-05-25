package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public String UsernameLoggedin;

    @FindBy(id="Email")
    private WebElement emailField;

    @FindBy(id="Password")
    private WebElement passwordField;

    @FindBy(id="LoginButton")
    private WebElement loginButton;

    @FindBy(id = "UserName")
    private WebElement userNameLabel;

    @FindBy(id = "AuthorsLink")
    private WebElement authorsLink;

    @FindBy(id = "BooksLink")
    private WebElement booksLink;



    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillEmail(String email)
    {
        emailField.clear();
        if (email != null)
            emailField.sendKeys(email);
    }

    public void fillPassword(String password)
    {
        passwordField.clear();
        if (password != null)
            passwordField.sendKeys(password);
    }



    public void logIn(String email, String password)
    {
        fillEmail(email);
        UsernameLoggedin=email;
        fillPassword(password);
        loginButton.click();
    }

    public void authorPage(){
        authorsLink.click();
    }

    public void bookPage(){
        booksLink.click();
    }


}
