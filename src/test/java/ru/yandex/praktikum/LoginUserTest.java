package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.constants.NameButtonsForLogin;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.constants.NameButtonsForLogin.*;

@RunWith(Parameterized.class)
public class LoginUserTest extends BaseTest {
    private final NameButtonsForLogin nameButtonsForLogin;

    public LoginUserTest(NameButtonsForLogin nameButtonsForLogin) {
        this.nameButtonsForLogin = nameButtonsForLogin;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {LOGIN_ON_HOME_PAGE},
                {LOGIN_ON_PERSONAL_ACCOUNT},
                {LOGIN_ON_REGISTER_PAGE},
                {LOGIN_ON_PASSWORD_RECOVERY}
        };
    }

    @Test
    @DisplayName("Авторизация пользователя")
    public void loginTest() {
        selectButton(nameButtonsForLogin);

        loginPage.waitLoadHeader();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickButtonLogin();

        homePage.waitLoadHeader();

        String actual = webDriver.getCurrentUrl();

        assertEquals("https://stellarburgers.nomoreparties.site/", actual);

    }
}
