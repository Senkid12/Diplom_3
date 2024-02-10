package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.model.User;
import ru.yandex.praktikum.pages.objects.HomePage;
import ru.yandex.praktikum.pages.objects.LoginPage;
import ru.yandex.praktikum.pages.objects.RegisterPage;
import ru.yandex.praktikum.service.UserGenerator;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.constants.Endpoints.BASE_URI;
import static ru.yandex.praktikum.constants.Endpoints.ENDPOINT_FOR_LOGIN_USER;

public class RegisterUserTest {
    private WebDriver webDriver;
    public WebDriverFactory webDriverFactory = new WebDriverFactory();
    private String actual;
    private final String expected = BASE_URI + ENDPOINT_FOR_LOGIN_USER;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected User user;
    protected final UserGenerator userGenerator = new UserGenerator();

    @Before
    public void setUp() {
        webDriver = webDriverFactory.getWebDriver();
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
        user = userGenerator.getUser();
        registerPage = new RegisterPage(webDriver);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @Test
    @DisplayName("Регистрация валидного пользователя")
    public void registerValidUser() {

        registerPage.setNameForRegister(user.getName());
        registerPage.setEmailFieldForRegister(user.getEmail());
        registerPage.setPasswordFieldForRegister(user.getPassword());
        registerPage.clickButtonForRegister();

        loginPage.waitLoadHeader();
        actual = webDriver.getCurrentUrl();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Регистрация пользователя с паролем меньше 6 символов")
    public void registerInvalidUser() {
        registerPage.setNameForRegister(user.getName());
        registerPage.setEmailFieldForRegister(user.getEmail());
        registerPage.setPasswordFieldForRegister(userGenerator.getInvalidPassword());
        registerPage.clickButtonForRegister();

        actual = registerPage.getTestForIncorrectPassword();
        System.out.println(actual);

        assertEquals("Некорректный пароль", actual);
    }

    @After
    @DisplayName("Выход из драйвера")
    public void CloseBrowser() {
        webDriver.quit();
    }
}
