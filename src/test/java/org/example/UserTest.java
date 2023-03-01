package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {
    User user = new User("abra@cada.bra", "login");//Правильные данные
    User user2 = new User("abra@cada.bra", "login");// Данные для проверки геттеров
    User user3 = new User();// Создание нового объекта с пустыми данными


    @org.junit.jupiter.api.Test
    void setEmail() {
        user3.setEmail("abra@cada.bra");
        assertEquals(user3.getEmail(), user.getEmail());//проверка устанавливаются ли данные
        // при создании объекта;
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            user.setEmail("");//Емайл пустой
            user.setEmail(null);//Email null
            user.setEmail("abra@cadabra");//емайл без точки
            user.setEmail("abracadab.ra");//емайл без @
            user.setEmail("login");//Логин и емайл одинаковы
            user.setEmail(user.getLogin());//Логин и емайл одинаковы

        });
        assertEquals("Неправильный емайл", thrown.getMessage());

    }


    @org.junit.jupiter.api.Test
    void setLogin() {
        user3.setLogin("login");
        assertEquals(user3.getLogin(), user.getLogin());//проверка устанавливаются ли данные
        // при создании объекта;
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            user.setLogin("");//Логин пустой
            user.setLogin(null);//Логин null
            user.setLogin("abra@cada.bra");//Логин и емайл одинаковы
            user.setLogin(user.getEmail());//Логин и емайл одинаковы

        });
        assertEquals("Неправильный логин", thrown.getMessage());

    }

    @Test
    void getEmail() {
        assertEquals(user2.getEmail(), user.getEmail());//правильно ли получает данные
        assertEquals("abra@cada.bra", user.getEmail());
    }

    @Test
    void getLogin() {
        assertEquals(user2.getLogin(), user.getLogin());//правильно ли получает данные
        assertEquals("login", user.getLogin());
    }
}
