package by.itacademy.linnik.pagesui;

import by.itacademy.linnik.singleoton.Singleton;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage {
    private WebDriver driver;

    public CatalogPage() {
        this.driver = Singleton.getDriver();
    }

    private static final Logger logger = LogManager.getLogger(CatalogPage.class);

    private final By BUTTON_COOKIE = By.xpath("//*[@id='modal-cookies']/div/div/div/div/div[2]/button[2]");
    private final By BUTTON_LAPTOP = By.xpath("(//a[@class='digi-product__label'])[2]");
    private final By ADD_CART = By.xpath("(//button[@class='digi-product__button'])[1]");
    private final By CLICK_CART = By.xpath("//a[@class='btn btn--block' and text()='Перейти в корзину']");


    @Step
    public CatalogPage scrollSite() {
        Actions action = new Actions(driver);
        try {
            action.scrollByAmount(0, 500).perform();
            return this;
        } catch (Exception e) {
            logger.info("Attempt to scroll the page");
            logger.error("An error occurred while scrolling the page", e);
            throw e;
        }
    }

    @Step
    public CatalogPage clickCookie() {
        try {
            driver.findElement(BUTTON_COOKIE).click();
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
    public CatalogPage clickAddCart() {
        try {
            driver.findElement(ADD_CART).click();
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
}
