package testAutomation.UI;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/login.feature",
        glue = "testAutomation.UI")

public class LoginStepDefinitions {
}
