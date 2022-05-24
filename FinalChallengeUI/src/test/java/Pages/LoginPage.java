package src.test.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    //private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "username")
    public WebElement usernameTxt;

    @FindBy(id = "password")
    public WebElement passwordTxt;

    @FindBy(id = "login_button")
    public WebElement loginBtn;

    public void LoginInTMDB(String username, String password){
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        loginBtn.click();
    }


}
