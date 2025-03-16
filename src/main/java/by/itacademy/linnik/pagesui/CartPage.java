package by.itacademy.linnik.pagesui;

import by.itacademy.linnik.singleoton.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage() {
        this.driver = Singleton.getDriver();
    }

    private static final Logger logger = LogManager.getLogger(CartPage.class);


    private final By BUTTON_REMOVE = By.xpath("(//span[text()='Удалить'])[1]");
    private final By TITLE_TEXT_CART_EMPTY = By.className("class='section-heading__title");
}
