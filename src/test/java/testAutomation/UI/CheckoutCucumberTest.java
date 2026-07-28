package testAutomation.UI;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CheckoutCucumberTest {

    SelenideElement addItemButtonBackpack = $(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button[contains(@class,'btn_inventory')]"));
    SelenideElement shoppingCartButton = $(By.xpath("//div[@id='shopping_cart_container']"));
    SelenideElement cartItemBackpack = $(By.xpath("//div[@class='cart_item_label']//div[@class='inventory_item_name']"));
    SelenideElement removeItemToCartButton = $(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
    SelenideElement itemPrice = $(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']"));
    SelenideElement checkOutButton = $(By.xpath("//button[@id='checkout']"));
    SelenideElement firstNameField = $(By.xpath("//input[@id='first-name']"));
    SelenideElement lastNameField = $(By.xpath("//input[@id='last-name']"));
    SelenideElement postalCode = $(By.xpath("//input[@id='postal-code']"));
    SelenideElement continueButton = $(By.xpath("//input[@id='continue']"));
    SelenideElement finishButton = $(By.xpath("//button[@id='finish']"));
    SelenideElement checkoutSuccessMessage = $(By.xpath("//h2[@data-test='complete-header']"));
    SelenideElement goBackHomeButton = $(By.xpath("//button[@id='back-to-products']"));
    SelenideElement overviewItemPrice = $(By.xpath("//div[@data-test='inventory-item-price']"));
    SelenideElement errorMessage = $(By.xpath("//h3[@data-test='error']"));

    String getItemName = "Sauce Labs Backpack";
    String getItemPrice;
    String getSuccessMessage= "Thank you for your order!";

    @And("User added an item to the cart")
    public void userAddedAnItemToTheCart() {
        try {
            addItemButtonBackpack.shouldBe(visible).click();
            getItemPrice = itemPrice.getText();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Cannot click Add to Cart button");
        }
    }

    @And("User clicks the cart")
    public void userClicksTheCart() {
        try {
            shoppingCartButton.shouldBe(visible).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Cannot click Add to Cart button");
        }
    }

    @And("Item is successfully added")
    public void itemIsSuccessfullyAdded() {
        try {
            String cartText = cartItemBackpack.shouldBe(visible, Duration.ofSeconds(10)).getText();
            sleep(1000);
            assertTrue(cartText.contains(getItemName));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Unable to add item");
        }
    }

    @And("User Remove the Item from the cart")
    public void userRemoveTheItemFromTheCart() {
        try {
            removeItemToCartButton.shouldBe(visible).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Unable to remove item");
        }
    }

    @And("Item is successfully removed")
    public void ItemIsSuccessfullyRemoved() {
        try {
            sleep(1000);
            cartItemBackpack.shouldBe(disappear);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Item is not removed");
        }
    }

    @And("User Checkout the Item")
    public void userCheckoutTheItem() {
        try {
            checkOutButton.shouldBe(visible).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Item is not removed");
        }
    }


    @And("User fillout customer information")
    public void userFilloutCustomerInformation() {
        try {
            continueButton.shouldBe(visible).click();
            errorMessage.shouldBe(visible); // Hello, this where is my negative test :)


            firstNameField.shouldBe(visible).click();
            firstNameField.sendKeys(RandomStringUtils.randomAlphabetic(5));
            sleep(500);
            lastNameField.click();
            lastNameField.sendKeys(RandomStringUtils.randomAlphabetic(5));
            sleep(500);
            postalCode.click();
            postalCode.sendKeys(RandomStringUtils.randomNumeric(5));
            sleep(500);
            continueButton.shouldBe(visible).click();

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Cannot Enter Customer details");
        }
    }

    @And("User verify the checkout and finish")
    public void userVerifyTheCheckoutAndFinish() {
        try {
            System.out.println(itemPrice);
            System.out.println(overviewItemPrice);

            assertTrue(overviewItemPrice.getText().contains(getItemPrice));
            assertTrue(cartItemBackpack.getText().contains(getItemName));
            sleep(1000);
            finishButton.shouldBe(visible).click();

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Not able to verify items");
        }
    }

    @And("a success order is displayed")
    public void aSuccessOrderIsDisplayed() {
        try {
            checkoutSuccessMessage.shouldBe(visible);
            assertTrue(checkoutSuccessMessage.getText().contains(getSuccessMessage));

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Not able to verify success checkout message");
        }
    }

    @And("user can go back to Home Page")
    public void userCanGoBackToHomePage() {
        try {
            goBackHomeButton.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Not Click go back home button");
        }
    }
}
