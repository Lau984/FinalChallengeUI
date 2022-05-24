package src.test.java.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.stringContainsInOrder;

public class ListsPage extends BasePage{
    public ListsPage(WebDriver driver) {super(driver); }

    @FindBy (xpath = "//a[@href='/list/new']")
    WebElement newListBtn;

    @FindBy (id="name")
    WebElement listNameTxt;

    @FindBy (id="description")
    WebElement listDescriptionTxt;

    @FindBy (id="step_1_submit")
    WebElement continueStep1Btn;

    @FindBy(id ="list_item_search")
    WebElement searchBar;

    @FindBy (xpath = "(//li[@role='option'])[1]")
    WebElement Option1;

    @FindBy (xpath="//a[@href='?active_nav_item=step_3']//parent::li")
    WebElement addImageOption;

    @FindBy (xpath="(//li//p)[1]")
    WebElement selectCoverImage;

    @FindBy (xpath="(//div[@class='details'])[1]")
    WebElement Movie5;

    @FindBy (xpath="(//div[@class='details']//a)[1]")
    WebElement title;


    public void CreateNewList(String Name, String Description){
        newListBtn.click();
        listNameTxt.sendKeys(Name);
        listDescriptionTxt.sendKeys(Description);
        continueStep1Btn.click();
    }

    public void SelectMoviesToList(String [] moviesList ){

        for(int i = 0; i < moviesList.length; i++)
        {
            searchBar.sendKeys(moviesList[i]);
            //WebElement firstItem=driver.findElement(By.id("list_item_search-list"));
            WebDriverWait wait1 = new WebDriverWait(driver,10);
            wait1.until(ExpectedConditions.elementToBeClickable(Option1));

            Option1.click();
            WebElement toasterSuccess=driver.findElement(By.xpath("//div[@class='notification success']"));

            wait1.until(ExpectedConditions.stalenessOf(toasterSuccess));
            System.out.println(i);
        }

        addImageOption.click();
    }

        public void VerifyListRecentlyCreated(String ListName, String [] moviesList){
            System.out.println(Movie5.getText());
            Assert.assertEquals(title.getText(),ListName);
            Assert.assertThat(Movie5.getText(), stringContainsInOrder(ListName,Integer.toString(moviesList.length)));
        }

}
