package src.test.java.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
    features = "src/test/resources/features/CreateLists.feature",
        glue = {"src.test.java.steps"}
)

public class TestRunner {

}
