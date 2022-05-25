package src.test.java.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;

public class Hooks {

    private static WebDriver driver;
    private static int numberOfScenario = 0;


    @Before
    public void setUp(){
        numberOfScenario++;
        System.out.println("Scenario number: "+ numberOfScenario);
        System.setProperty("webdriver.chrome.driver","./src/test/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        String linkLogin = "https://www.themoviedb.org/login";
        driver.get(linkLogin);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("The scenario number " +numberOfScenario + " was executed successfully");
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
