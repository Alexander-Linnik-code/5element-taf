package by.itacademy.linnik.ui;

import by.itacademy.linnik.pagesui.HomePage;
import by.itacademy.linnik.singleoton.Singleton;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLoginPage {
    @Test
    @Description("Checking the login to your personal account")
    public void Test2() {
        String actual = new HomePage()
                .open()
                .clickLoginButton()
                .enterPhoneNumber("+375259987926")
                .clickGetCode()
                .enteringCodeFromSms("1234")
                .clickConfirmPhoneButton()
                .gettingErrorText();

        Assertions.assertEquals("Код не совпал. Осталось 3 попытки", actual);
        Singleton.quit();
    }
}
