package by.itacademy.linnik.pagesui;

import by.itacademy.linnik.singleton.Singleton;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LaptopPage {
    private WebDriver driver;

    public LaptopPage() {
        this.driver = Singleton.getDriver();
    }

    private static final Logger logger = LogManager.getLogger(LaptopPage.class);

    private final By TITLE_LAPTOP = By.xpath("//h1");

    @Step
    public String getTextModelLaptop() {
        try {
            return Singleton.getTextElement(TITLE_LAPTOP);
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
