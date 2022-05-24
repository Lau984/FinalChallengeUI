package src.test.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {super(driver);}


    @FindBy (xpath = "//li[@class='user']//span")
    public WebElement MyProfilePhoto;

    @FindBy (xpath = "//div[@class='k-tooltip-content']//a[contains(@href,'lists')]")
    public WebElement ListsOption;

    By ListsOptionBy = By.xpath("//ul[@id='new_shortcut_bar']//a[contains(@href,'lists')]");



    public void SelectListOptionOfMyProfile(){
        //WebDriverWait wait = new WebDriverWait(driver,5);
        //wait.until(ExpectedConditions.elementToBeClickable(ListsOptionBy));
        //WebElement ListsOption = driver.findElement(ListsOptionBy);
        //ListsOption.click();

        MyProfilePhoto.click();
        ListsOption.click();
    }


}
