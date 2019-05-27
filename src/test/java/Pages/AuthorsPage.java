package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AuthorsPage {
    public WebDriver driver;

    @FindBy(name = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "CreateButton")
    private WebElement createButton;

    @FindBy(className = "text-danger")
    private WebElement validationError;

    @FindBy(name = "SearchString")
    private WebElement searchBar;

    @FindBy(id = "AuthorId")
    private WebElement authorDelete;

    @FindBy(xpath = "//table[@class='table']/tbody/tr")
    private List<WebElement> tableContent;


    public AuthorsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void toAuthors() {

        driver.get("http://bookcatalog.azurewebsites.net/Authors");
    }

    public void toCreate() {
        driver.get("http://bookcatalog.azurewebsites.net/Authors/Create");

    }

    public void createAuthor(String firstN, String lastN) {
        this.firstName.sendKeys(firstN);
        this.lastName.sendKeys(lastN);
        this.createButton.click();
    }

    public void searchAuthors(String searchPhrase) {
        searchBar.sendKeys(searchPhrase);
        searchBar.submit();
    }

    public String getAuthor(int position) {
        WebElement tr = driver.findElement(By.xpath("(//table[@class='table']/tbody/tr)[" + position + "]"));
        return tr.getText();
    }

    public void EditAuthor(int id, String firstN, String lastN) {
        driver.get("http://bookcatalog.azurewebsites.net/Authors/Edit/" + id);
        this.firstName.clear();
        this.firstName.sendKeys(firstN);

        this.lastName.clear();
        this.lastName.sendKeys(lastN);

        this.lastName.submit();
    }

    public int howManyAuthors() {
        return tableContent.size();
    }

    public List<WebElement> getAuthors() {
        return tableContent;
    }


    public String getLastAuthor() {
        WebElement tr = driver.findElement(By.xpath("(//table[@class='table']/tbody/tr)[last()]"));
        return tr.getText();
    }
    public Boolean findUnvalidMessage(String message){
        return validationError.getText().contains(message);
    }



    public void deleteLastAuthor(){
        WebElement tr = driver.findElement(By.xpath("(//table[@class='table']/tbody/tr[last()]/td[last()]/a[last()])"));
        driver.navigate().to(tr.getAttribute("href"));
        authorDelete.submit();
    }
}