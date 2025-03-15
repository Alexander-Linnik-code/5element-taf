package by.itacademy.linnik.pagesui;

import by.itacademy.linnik.singleoton.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = Singleton.getDriver();
    }

    private final By LINE_FOR_ENTERING_A_PHONE_NUMBER = By.xpath("(//input[@class='inp inp inp--lg'])[6]");

    private final By GET_CODE_BUTTON = By.xpath("(//button[@class='btn btn--lg btn--block send-button'])[1]");

    private final By CODE_ENTRY_FIELD = By.xpath("(//input[@class='inp code-input'])[1]");

    private final By TEXT_IS_NOT_CORRECT_CODE = By.xpath("//span[text()='Код не совпал. Осталось 3 попытки']");

    private final By CONFIRM_PHONE_BUTTON = By.xpath("(//button[@class='btn btn--lg btn--block submit-button'])[1]");

}
