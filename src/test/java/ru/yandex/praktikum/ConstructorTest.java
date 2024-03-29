package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.constants.SectionName;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.constants.SectionName.*;

@RunWith(Parameterized.class)
public class ConstructorTest extends BaseTest {
    private final SectionName sectionName;
    private final List<String> ingredientsBurger = Arrays.asList("Булки", "Соусы", "Начинки");

    public ConstructorTest(SectionName sectionName) {
        this.sectionName = sectionName;
    }

    @Parameterized.Parameters
    public static Object[][] geParameters() {
        return new Object[][]{
                {BUN},
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    @DisplayName("Переход по разделам Конструктора")
    public void clickSectionTest() {
        homePage.clickSection(sectionName);

        String actual = homePage.getClassName(sectionName);

        assertTrue(ingredientsBurger.contains(actual));
    }
}
