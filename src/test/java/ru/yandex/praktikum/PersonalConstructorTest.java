package ru.yandex.praktikum;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.constants.ButtonNameForConstructor;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.constants.ButtonNameForConstructor.CONSTRUCTOR;
import static ru.yandex.praktikum.constants.ButtonNameForConstructor.LOGO_STELLAR_BURGER;

@RunWith(Parameterized.class)
public class PersonalConstructorTest extends BaseTest {
    private ButtonNameForConstructor buttonName;

    public PersonalConstructorTest(ButtonNameForConstructor buttonName) {
        this.buttonName = buttonName;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {CONSTRUCTOR},
                {LOGO_STELLAR_BURGER}
        };
    }

    @Test
    @DisplayName("Переход из ЛК в Конструктор")
    public void transitionToConstructorFromLk() {
        transitionToPersonalAccount();

        userPage.waitLoadingPage();
        userPage.changeButton(buttonName);

        String expectedUrl = "https://stellarburgers.nomoreparties.site/";

        assertEquals(expectedUrl, webDriver.getCurrentUrl());
    }

    @Step("Переход в ЛК")
    private void transitionToPersonalAccount() {
        homePage.clickPersonalAccount();
        loginPage.waitLoadHeader();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickButtonLogin();
        homePage.clickPersonalAccount();
    }
}
