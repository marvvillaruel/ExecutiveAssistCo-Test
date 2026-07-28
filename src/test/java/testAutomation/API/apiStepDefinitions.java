package testAutomation.API;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/API/apiTest.feature",
        glue = "testAutomation.API")

public class apiStepDefinitions {

}
