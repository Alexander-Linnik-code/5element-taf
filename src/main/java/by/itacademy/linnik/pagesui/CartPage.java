package by.itacademy.linnik.pagesui;

import by.itacademy.linnik.singleoton.Singleton;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage() {
        this.driver = Singleton.getDriver();
    }

    private static final Logger logger = LogManager.getLogger(CartPage.class);

    private final By BUTTON_REMOVE = By.xpath("(//span[text()='Удалить'])[1]");

    private final By TITLE_TEXT_CART_EMPTY = By.xpath("//div[@class='section-heading__title']");

    @Step
    public CartPage clickRemoveButton(){
        try {
            driver.findElement(BUTTON_REMOVE).click();
            return this;
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (Exception e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
    }

    @Step
    public String getTextCartEmpty(){
        try {
            return driver.findElement(TITLE_TEXT_CART_EMPTY).getText();
        } catch (NoSuchElementException e) {
            logger.info("Trying to extract text, but the element was not found.");
            logger.error("Element not found", e);
            return "Element not found";
        } catch (Exception e) {
            logger.info("Trying to extract text, but an error occurred.");
            logger.error("Error encountered while trying to get error text", e);
            return "Error occurred: " + e.getMessage();
        }
    }
}
