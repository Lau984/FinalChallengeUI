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
    String [] emptyMoviesList = {};
    private LoginPage loginPage = new LoginPage(driver);
    private ListsPage listsPage = new ListsPage(driver);
    private HomePage homePage = new HomePage(driver);
    String userName="lau98";
    String password="LSMM";

    String Name="List created on "+date()+time();
    String Description="Description of list";
    String Movie="Harry Potter";
    String linkLists = "https://www.themoviedb.org/u/"+userName+"/lists";


    @Given("Given I’m a logged in user")
    public void given_i_m_a_logged_in_user() {
        loginPage.LoginInTMDB(userName,password);

    }
    @When("I create a list with name and description")
    public void i_create_a_list_with_name_and_description() {
        homePage.SelectListOptionOfMyProfile();
        listsPage.CreateNewList(Name,Description);

    }
    @Then("I have a list to add movies")
    public void i_have_a_list_to_add_movies() {
        listsPage.GetAndRefresh(linkLists);
        listsPage.VerifyListRecentlyCreated(Name,emptyMoviesList);
    }

    @Given("I’m a logged in user")
    public void i_m_a_logged_in_user() {
        given_i_m_a_logged_in_user();
        //throw new io.cucumber.java.PendingException();
    }


    @Given("I have a created list")
    public void i_have_a_created_list() {
        listsPage.GetAndRefresh(linkLists);
        listsPage.ExistList();
        Name=listsPage.titleFirstMovie.getText();
        System.out.println("First:"+listsPage.firstMovie.getText());

        //listsPage.CreateNewList(Name,Description);

    }

    @When("I add a movie to the list")
    public void i_add_a_movie_to_the_list() {
        listsPage.SelectList();
        listsPage.editList.click();
        listsPage.SelectMoviesToList(moviesList);

    }

    @Then("the list has the added movie")
    public void the_list_has_the_added_movie() {
        listsPage.GetAndRefresh(linkLists);
        listsPage.VerifyListRecentlyCreated(Name,moviesList);

    }


    @Given("the list has items")
    public void the_list_has_items() {
        listsPage.TheListHasItems();


    }
    @When("I delete a movie from the list")
    public void i_delete_a_movie_from_the_list() {
        listsPage.editList.click();
        listsPage.deleteElement.click();
        listsPage.GetAndRefresh(linkLists);

    }
    @Then("the list is updated without the deleted list")
    public void the_list_is_updated_without_the_deleted_list() {
        System.out.println("Then: "+listsPage.firstMovie.getText());

    }



}
