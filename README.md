# ** Дипломный проект по теме Тестирование UI на курсе "Автоматизатор тестирования на Java"**

#### **Стэк проекта**

Selenium, Java11, Maven, Allure

#### **Как запустить**

**Запустить тесты через Google Chrome:**

```shell
mvn clean test -Dbrowser=chrome allure:report
```
```shell
mvn clean test -Dbrowser=chrome allure:serve
```

**Запустить тесты через Yandex Browser:**

```shell
mvn clean test -Dbrowser=yandex allure:report
```
```shell
mvn clean test -Dbrowser=yandex allure:serve
```

## **Техническое задание**
Протестировать веб-приложение [Stellar Burgers](https://stellarburgers.nomoreparties.site/)

Описать элементы, которые будут использоваться в тестах, с помощью Page Object. Протестировать функциональность в Google Chrome, Подключить Allure-отчёт.

### **Регистрация:**

1. Успешная регистрация
2. Ошибка для некорректного пароль. Минимальный пароль - шесть символов

### **Авторизация:**

1. по кнопке «Войти в аккаунт» на главной
2. через кнопку «Личный кабинет»
3. через кнопку в форме регистрации
4. через кнопку в форме восстановления пароля

### **Переход в Личный в Личный кабинет:**

1. Переход по клику на "Личный кабинет"

### **Переход из личного кабинета в конструктор:**

1. Переход по клику на «Конструктор»
2. Переход по клику на логотип Stellar Burgers

### **Выход из аккаунта:**

1. выход по кнопке «Выйти» в личном кабинете.

### **Раздел «Конструктор»:**

1. Переход к разделу «Булки»
2. Переход к разделу «Соусы»
3. Переход к разделу «Начинки»