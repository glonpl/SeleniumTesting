package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {


    @FindBy(id = "logoutForm")
    private WebElement logoutForm;

    public void logOut(){
        logoutForm.submit();
    }
}
