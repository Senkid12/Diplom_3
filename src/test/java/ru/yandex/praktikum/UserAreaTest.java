package ru.yandex.praktikum;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserAreaTest extends BaseTest {
    @Test
    @DisplayName("Переход в Личный кабинет авторизованным пользователем")
    public void personalAreaButtonWithAuthUser() {
        LoginPersonalAccount();

        homePage.clickPersonalAccount();
        userPage.waitLoadingPage();

        assertEquals(user.getName(), userPage.getUserName());
        assertEquals(user.getEmail(), userPage.getUserLogin());
    }

    @Test
    @DisplayName("Выход из Личного кабинета")
    public void exitFromLk() {
        LoginPersonalAccount();
        toPersonalAccountAfterLogin();

        userPage.clickExit();
        loginPage.waitLoadHeader();

        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";

        assertEquals(expectedUrl, webDriver.getCurrentUrl());
    }

    @Step("Авторизация")
    private void LoginPersonalAccount() {
        homePage.clickPersonalAccount();
        loginPage.waitLoadHeader();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickButtonLogin();
    }

    @Step("Переход в ЛК после авторизации")
    private void toPersonalAccountAfterLogin() {
        homePage.clickPersonalAccount();
        userPage.waitLoadingPage();
    }

}
