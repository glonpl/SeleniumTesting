package Pages;

public class HomePage {
    import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class HomePage {

        private String webLink;

        public String getWebLink() {
            return webLink;
        }

        @FindBy(className="marketing-header--logo")
        private WebElement homeHeaderLogo;

        @FindBy(linkText="Log in")
        private WebElement homeLoginButton;

        public HomePage(WebDriver driver) {
            webLink = "https://bitbucket.org/";
            PageFactory.initElements(driver, this);
        }

        public boolean checkHomeHeader()
        {
            return !(homeHeaderLogo == null);
        }

        public void clickLoginButton()
        {
            homeLoginButton.click();
        }
    }
}
