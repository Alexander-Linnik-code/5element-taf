package by.itacademy.linnik.ui;

import by.itacademy.linnik.pagesui.HomePage;
import by.itacademy.linnik.singleoton.Singleton;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCart {
    @Test
    @Description("Adding and then removing an item from the shopping cart, checking the title.")
    public void test1() {
        String actual = new HomePage()
                .open()
                .clickSearchAndWriteTextAndClickEnter("Lenovo")
                .clickCookie()
                .scrollSite()
                .clickAddCart()
                .clickCart()
                .clickRemoveButton()
                .getTextCartEmpty();
        Assertions.assertEquals("В корзине еще нет товаров", actual);
        Singleton.quit();
    }
}
