package testAutomation.UI;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.*;

public class LoginCucumberTest {
    WebDriver driver;
    String Url = "https://www.saucedemo.com/";
    String getHeaderText = "Swag Labs";


  SelenideElement usernameField = $(By.xpath(""));
  SelenideElement passwordField = $(By.xpath(""));
  SelenideElement loginButton = $(By.xpath(""));


    @Given("User navigates to Swag Labs login page")
    public void userNavigatesToSwagLabsLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("User enter valid username and password")
    public void userEnterValidUsernameAndPassword() {
        try {

        }catch (NoSuchElementException e){
            e.printStackTrace();
            fail("Not Able to enter valid username and password");
        }
    }

    @And("User click Login button")
    public void userClickLogiButton() {
        try {

        }catch (NoSuchElementException e){
            e.printStackTrace();
            fail("Cannot click login button");
        }
    }


    @And("User is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        try {

        }catch (NoSuchElementException e){
            e.printStackTrace();
            fail("No Items are Present");
        }
    }



}
