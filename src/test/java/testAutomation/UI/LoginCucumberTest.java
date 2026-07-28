package testAutomation.UI;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

public class LoginCucumberTest {
    SelenideElement usernameField = $(By.xpath("//input[@id='user-name']"));
    SelenideElement passwordField = $(By.xpath("//input[@id='password']"));
    SelenideElement loginButton = $(By.xpath("//input[@id='login-button']"));
    ElementsCollection inventoryItems = $$x("//div[@data-test='inventory-item']");

    @Given("User navigates to Swag Labs login page")
    public void userNavigatesToSwagLabsLoginPage() {
        open("https://www.saucedemo.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @And("^User enter valid (.+) and (.+)$")
    public void userEnterValidUsernameAndPassword(String username, String password) {
        try {
            usernameField.shouldBe(visible, Duration.ofSeconds(30)).click();
            usernameField.sendKeys(username);
            sleep(1000);

            passwordField.shouldBe(visible).click();
            passwordField.sendKeys(password);

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Not able to enter valid username and password");
        }
    }

    @And("User click Login button")
    public void userClickLogiButton() {
        try {
            loginButton.click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            fail("Cannot click login button");
        }
    }

    @And("User is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        try {
            for (SelenideElement item : inventoryItems) {
                item.shouldBe(visible, Duration.ofSeconds(20));
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
            fail("No Items are Present");
        }
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
