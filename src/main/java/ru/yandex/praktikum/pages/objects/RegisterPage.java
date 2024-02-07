package ru.yandex.praktikum.pages.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private final WebDriver driver;
    private final By allFieldsForRegister = By.className("input__textfield");
    private final By buttonForRegister = By.className("button_button__33qZ0");
    private final By incorrectPassword = By.className("input__error");
    private final By buttonLogin = By.linkText("Войти");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getNameFieldForRegister() {
        return driver.findElements(allFieldsForRegister).get(0);
    }
    public WebElement getEmailFieldForRegister() {
        return driver.findElements(allFieldsForRegister).get(1);
    }
    public WebElement getPasswordFieldForRegister() {
        return driver.findElements(allFieldsForRegister).get(2);
    }
    public void setNameForRegister(String name) {
        getNameFieldForRegister().sendKeys(name);
    }
    public void setEmailFieldForRegister(String email) {
        getEmailFieldForRegister().sendKeys(email);
    }
    public void setPasswordFieldForRegister(String password) {
        getPasswordFieldForRegister().sendKeys(password);
    }
    public void clickButtonForRegister() {
        driver.findElement(buttonForRegister).click();
    }
    public void clickButtonForLogin() {
        driver.findElement(buttonLogin).click();
    }
    public String getTestForIncorrectPassword() {
        return driver.findElement(incorrectPassword).getText();
    }
}
