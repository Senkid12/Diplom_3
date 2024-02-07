package ru.yandex.praktikum.service;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import ru.yandex.praktikum.model.User;

public class UserGenerator {
    Faker faker = new Faker();

    public User getUser() {
        return User.builder()
                .email(String.format("%s@yandex.ru", faker.name().username()))
                .password(RandomStringUtils.randomAlphanumeric(10))
                .name(faker.name().fullName())
                .build();
    }
    public String getInvalidPassword() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}