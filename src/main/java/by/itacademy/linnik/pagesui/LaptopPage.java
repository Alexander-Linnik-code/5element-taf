package by.itacademy.linnik.pagesui;

import by.itacademy.linnik.singleoton.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaptopPage {
    private WebDriver driver;

    public LaptopPage() {
        this.driver = Singleton.getDriver();
    }

    private static final Logger logger = LogManager.getLogger(LaptopPage.class);

    private final By TITLE_LAPTOP = By.xpath("//h1");
}
