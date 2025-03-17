package by.itacademy.linnik.pagesui;

import by.itacademy.linnik.singleoton.Singleton;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = Singleton.getDriver();
    }

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    private final String URL = "https://5element.by/";

    private final By BUTTON_ACCOUNT = By.xpath("(//div[@class='h-drop__text'])[4]");

    private final By SEARCH_BAR = By.xpath("//input[@class='inp inp--lg digi-instant-search jc-ignore']");

    private final By LOGIN_BUTTON = By.xpath("(//div[text()='Вход'])[2]");

    @Step
    public HomePage open() {
        try {
            driver.get(URL);
            return this;
        } catch (NullPointerException e) {
            logger.info("Attempted to open web driver, but driver failed to initialize.");
            logger.error("Driver is not initialized", e);
            throw e;
        } catch (Exception e) {
            logger.info("Attempted to open web driver, but an error occurred.");
            logger.error("Unexpected error occurred while trying to open the URL: " + URL, e);
            throw e;
        }
    }


    @Step
    public HomePage clickSearch() {
        try {
            Singleton.clickElement(SEARCH_BAR);
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
    public HomePage writeText(String search) {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(search).sendKeys(Keys.ENTER).perform();
            return this;
        } catch (NullPointerException e) {
            logger.info("Tried to press the ENTER button, but the driver did not work.");
            logger.error("Driver is not initialized", e);
            throw e;
        } catch (Exception e) {
            logger.info("Attempting to press the ENTER button, an error occurred.");
            logger.error("Error encountered while trying to write text and press Enter", e);
            throw e;
        }
    }

    @Step
    public LoginPage clickLoginButton() {
        try {
            Singleton.clickElement(LOGIN_BUTTON);
            return new LoginPage();
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
    public CatalogPage clickSearchAndWriteTextAndClickEnter(String search) {
        clickSearch();
        writeText(search);
        return new CatalogPage();
    }
}
