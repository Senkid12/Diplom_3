package ru.yandex.praktikum.pages.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import ru.yandex.praktikum.constants.NameButtonsForLogin;

public class RecoveryPasswordPage {
    private final By loginButton = By.linkText("Войти");
    private final WebDriver driver;
    public RecoveryPasswordPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
