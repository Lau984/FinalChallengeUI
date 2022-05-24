package src.test.java.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.test.java.Pages.HomePage;
import src.test.java.Pages.ListsPage;
import src.test.java.Pages.LoginPage;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;


public class DemoSteps {

    private WebDriver driver = Hooks.getDriver();
    String [] moviesList = {"a","b","c"};
    private LoginPage loginPage = new LoginPage(driver);
    private ListsPage listsPage = new ListsPage(driver);
    private HomePage homePage = new HomePage(driver);
    String userName="lau98";
    String password="LSMM";

    String Name="List created on "+date()+time();
    String Description="Description of list";
    String Movie="Harry Potter";
    String linkLists = "https://www.themoviedb.org/u/"+userName+"/lists";


    @Given("Laura is a registered user who wants to create a list")
    public void laura_is_a_registered_user_who_wants_to_create_a_list() {

        loginPage.LoginInTMDB(userName,password);
        homePage.SelectListOptionOfMyProfile();
    }
    @When("Laura create a list with some movies to watch then")
    public void laura_create_a_list_with_some_movies_to_watch_then() {

        listsPage.CreateNewList(Name,Description);
        listsPage.SelectMoviesToList(moviesList);

    }

    @Then("The list is already created and is displayed in the lists view")
    public void the_list_is_already_created_and_is_displayed_in_the_lists_view() {

        driver.get(linkLists);
        listsPage.VerifyListRecentlyCreated(Name, moviesList);

    }
}
