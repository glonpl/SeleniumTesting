package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {


    @FindBy(id = "logoutForm")
    private WebElement logoutForm;

    public void logOut(){
        logoutForm.submit();
    }
}
