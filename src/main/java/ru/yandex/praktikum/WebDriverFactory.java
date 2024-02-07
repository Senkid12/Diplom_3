package ru.yandex.praktikum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
    public WebDriver getWebDriver() {
        switch (System.getProperty("browser")) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                return new ChromeDriver();
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }
}
