package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.constants.NameButtonsForLogin;
import ru.yandex.praktikum.model.User;
import ru.yandex.praktikum.pages.objects.*;
import ru.yandex.praktikum.service.UserGenerator;

import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.constants.Endpoints.BASE_URI;

public class BaseTest {
    protected WebDriver webDriver;
    protected User user;
    protected final UserGenerator userGenerator = new UserGenerator();
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    private RecoveryPasswordPage recoveryPasswordPage;
    protected UserPage userPage;
    public WebDriverFactory webDriverFactory = new WebDriverFactory();

    @Before
    public void setUp() {
        webDriver = webDriverFactory.getWebDriver();
        webDriver.get("https://stellarburgers.nomoreparties.site");
        registerPage = new RegisterPage(webDriver);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        userPage = new UserPage(webDriver);
        recoveryPasswordPage = new RecoveryPasswordPage(webDriver);
        createUser();
    }

    @After
    @DisplayName("Удаление user и закрытие браузера")
    public void deleteUserAndCloseBrowser() {
        System.out.println("Пользователь " + user.getName() + " Был удален");
        deleteUser();
        webDriver.quit();
    }

    private void createUser() {
        user = userGenerator.getUser();
        given().contentType(ContentType.JSON)
                .body(user)
                .post(BASE_URI + "/api/auth/register");
    }

    private void deleteUser() {
        String accessToken = given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(BASE_URI + "/api/auth/login")
                .body().path("accessToken");
        given().contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .body(user).delete(BASE_URI + "/api/auth/user");
    }

    public void selectButton(NameButtonsForLogin nameButtonsForLogin){
        switch (nameButtonsForLogin) {
            case LOGIN_ON_HOME_PAGE:
                homePage.clickButtonLogin();
                break;
            case LOGIN_ON_PERSONAL_ACCOUNT:
                homePage.clickPersonalAccount();
                break;
            case LOGIN_ON_REGISTER_PAGE:
                homePage.clickPersonalAccount();
                loginPage.clickButtonRegister();
                registerPage.clickButtonForLogin();
                break;
            case LOGIN_ON_PASSWORD_RECOVERY:
                homePage.clickPersonalAccount();
                loginPage.clickButtonForRecoveryPassword();
                recoveryPasswordPage.clickLoginButton();
                break;
        }
    }
}