package by.itacademy.linnik.UI;

import by.itacademy.linnik.pagesui.HomePage;
import by.itacademy.linnik.singleoton.Singleton;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLaptop {
    @Test
    @Description("We check the presence of the laptop header")
    public void Test1() {
        String actual = new HomePage()
                .open()
                .clickSearchAndWriteTextAndClickEnter("lenovo")
                .clickCookie()
                .scrollSite()
                .clickLaptop()
                .getTextModelLaptop();
        Assertions.assertEquals("Игровой ноутбук Lenovo IdeaPad Gaming 3 16IAH7 82SA00FB", actual);
        Singleton.quit();
    }
}
