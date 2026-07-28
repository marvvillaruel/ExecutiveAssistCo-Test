package testAutomation.UI;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/UI/checkout.feature",
        glue = "testAutomation.UI")

public class CheckoutStepDefinitions {

}
