package testAutomation.UI;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

public class LoginCucumberTest {
    WebDriver driver;
    String Url = "https://www.saucedemo.com/";
    String getHeaderText = "Swag Labs";

    String standardUserName = "standard_user";
    String standardPassword = "secret_sauce";


    SelenideElement usernameField = $(By.xpath("//input[@id='user-name']"));
    SelenideElement passwordField = $(By.xpath("//input[@id='password']"));
    SelenideElement loginButton = $(By.xpath("//input[@id='login-button']"));

    ElementsCollection inventoryItems = $$x("//div[@data-test='inventory-item']");

    @Given("User navigates to Swag Labs login page")
    public void userNavigatesToSwagLabsLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        open("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @And("User enter valid username and password")
    public void userEnterValidUsernameAndPassword() {
        try {
            usernameField.shouldBe(visible, Duration.ofSeconds(30)).click();
            usernameField.sendKeys(standardUserName);
            sleep(1000);

            passwordField.shouldBe(visible).click();
            passwordField.sendKeys(standardPassword);

        }catch (NoSuchElementException e){
            e.printStackTrace();
            fail("Not Able to enter valid username and password");
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
}
