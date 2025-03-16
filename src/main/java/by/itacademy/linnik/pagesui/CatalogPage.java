package by.itacademy.linnik.pagesui;

import by.itacademy.linnik.singleoton.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
