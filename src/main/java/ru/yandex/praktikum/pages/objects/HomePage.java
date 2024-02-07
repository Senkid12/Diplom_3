package ru.yandex.praktikum.pages.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.constants.SectionName;

import java.time.Duration;

import static ru.yandex.praktikum.constants.SectionName.*;

public class HomePage {
    private final WebDriver driver;
    private final By buttonLogin = By.className("button_button__33qZ0");
    private final By personalAccount = By.xpath(".//p[text() = 'Личный Кабинет']");
    private final By homePageHeader = By.xpath(".//*[@class='active']");
    public final By sectionSauce = By.xpath(".//*[text()='Соусы']//parent::div");
    public final By sectionFilling = By.xpath(".//*[text()='Начинки']//parent::div");
    public final By sectionBun = By.xpath(".//*[text()='Булки']//parent::div");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitLoadHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(homePageHeader).isEnabled()
        ));
    }
    public void clickButtonLogin() {
        waitLoadHeader();
        driver.findElement(buttonLogin).click();
    }

    public void clickPersonalAccount() {
        waitLoadHeader();
        driver.findElement(personalAccount).click();
    }


    public void clickSauce() {
        waitLoadHeader();
        driver.findElement(sectionSauce).click();
    }
    public void clickBun() {
        waitLoadHeader();
        clickSauce();
        driver.findElement(sectionBun).click();
    }

    public void clickFilling() {
        waitLoadHeader();
        driver.findElement(sectionFilling).click();
    }

    public void clickSection(SectionName sectionName) {
        switch (sectionName) {
            case BUN:
                clickBun();
                break;
            case SAUCE:
                clickSauce();
                break;
            case FILLING:
                clickFilling();
                break;
        }
    }
    public WebElement getSection(SectionName sectionName) {
        switch (sectionName) {
            case BUN:
                return driver.findElement(sectionBun);
            case SAUCE:
                return driver.findElement(sectionSauce);
            case FILLING:
                return driver.findElement(sectionFilling);
            default:
                throw new RuntimeException("Некорректное название элемента");
        }
    }
    public String getClassName(SectionName sectionName) {
        return getSection(sectionName).getAttribute("class");
    }

}
