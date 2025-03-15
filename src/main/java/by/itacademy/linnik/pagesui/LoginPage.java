package by.itacademy.linnik.pagesui;

import by.itacademy.linnik.singleoton.Singleton;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = Singleton.getDriver();
    }

    private final By LINE_FOR_ENTERING_A_PHONE_NUMBER = By.xpath("(//input[@class='inp inp inp--lg'])[6]");

    private final By GET_CODE_BUTTON = By.xpath("(//button[@class='btn btn--lg btn--block send-button'])[1]");

    private final By CODE_ENTRY_FIELD = By.xpath("(//input[@class='inp code-input'])[1]");

    private final By TEXT_IS_NOT_CORRECT_CODE = By.xpath("//span[text()='Код не совпал. Осталось 3 попытки']");

    private final By CONFIRM_PHONE_BUTTON = By.xpath("(//button[@class='btn btn--lg btn--block submit-button'])[1]");

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @Step
    public LoginPage enterPhoneNumber(String phoneNumber) {
        try {
            driver.findElement(LINE_FOR_ENTERING_A_PHONE_NUMBER).sendKeys(phoneNumber);
            return this;
        } catch (NoSuchElementException e) {
            logger.info("Attempted to enter a phone number but the field was not found.");
            logger.error("Element to click not found", e);
            throw e;
        } catch (Exception e) {
            logger.info("Attempted to enter text but an error occurred.");
            logger.error("There was an error entering your phone number");
            throw e;
        }
    }

    @Step
    public LoginPage clickGetCode() {
        try {
            driver.findElement(GET_CODE_BUTTON).click();
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
    public LoginPage enteringCodeFromSms(String code) {
        try {
            driver.findElement(CODE_ENTRY_FIELD).sendKeys(code);
            return this;
        } catch (NoSuchElementException e) {
            logger.info("Attempted to enter a number from SMS, but the element was not found.");
            logger.error("Code entry field not found", e);
            throw e;
        } catch (Exception e) {
            logger.info("Attempted to enter a number from SMS, but an error occurred.");
            logger.error("Error encountered while trying to enter SMS code", e);
            throw e;
        }
    }

    @Step
    public LoginPage clickConfirmPhoneButton() {
        try {
            driver.findElement(CONFIRM_PHONE_BUTTON).click();
            return this;
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click on phone number verification, but the element was not found.");
            logger.error("Confirm phone button not found", e);
            throw e;
        } catch (Exception e) {
            logger.info("Attempted to click on confirm phone number, but an error occurred.");
            logger.error("Error encountered while trying to click confirm phone button", e);
            throw e;
        }
    }

    @Step
    public String gettingErrorText() {
        try {
            return driver.findElement(TEXT_IS_NOT_CORRECT_CODE).getText();
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
