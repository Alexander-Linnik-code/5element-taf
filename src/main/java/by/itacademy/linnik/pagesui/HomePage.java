package by.itacademy.linnik.pagesui;

import by.itacademy.linnik.singleoton.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
