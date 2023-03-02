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

        RuntimeException emailIsEmpty = assertThrows(RuntimeException.class, () -> {
            user.setEmail("");//Емайл пустой
        });
        assertEquals("Неправильный емайл", emailIsEmpty.getMessage());


        RuntimeException emailIsNull = assertThrows(RuntimeException.class, () -> {
            user.setEmail(null);//Email null
        });
        assertEquals("Неправильный емайл", emailIsNull.getMessage());


        RuntimeException emailWithoutDot = assertThrows(RuntimeException.class, () -> {
            user.setEmail("abra@cadabra");//емайл без точки
        });
        assertEquals("Неправильный емайл", emailWithoutDot.getMessage());


        RuntimeException emailWithout = assertThrows(RuntimeException.class, () -> {
            user.setEmail("abracada.bra");//емайл без @
        });
        assertEquals("Неправильный емайл", emailWithout.getMessage());


        RuntimeException emailIsSame1 = assertThrows(RuntimeException.class, () -> {
            user.setEmail("login");//Логин и емайл одинаковы
        });
        assertEquals("Неправильный емайл", emailIsSame1.getMessage());


        RuntimeException emailIsSame2 = assertThrows(RuntimeException.class, () -> {
            user.setEmail(user.getLogin());//Логин и емайл одинаковы
        });
        assertEquals("Неправильный емайл", emailIsSame2.getMessage());

    }


    @org.junit.jupiter.api.Test
    void setLogin() {
        user3.setLogin("login");
        assertEquals(user3.getLogin(), user.getLogin());//проверка устанавливаются ли данные
        // при создании объекта;
        RuntimeException loginIsEmpty = assertThrows(RuntimeException.class, () -> {
            user.setLogin("");//Логин пустой
        });
        assertEquals("Неправильный логин", loginIsEmpty.getMessage());


        RuntimeException loginIsNull = assertThrows(RuntimeException.class, () -> {
            user.setLogin(null);//Логин null
        });
        assertEquals("Неправильный логин", loginIsNull.getMessage());


        RuntimeException loginIsSame1 = assertThrows(RuntimeException.class, () -> {
            user.setLogin("abra@cada.bra");//Логин и емайл одинаковы
        });
        assertEquals("Неправильный логин", loginIsSame1.getMessage());


        RuntimeException loginIsSame2 = assertThrows(RuntimeException.class, () -> {
            user.setLogin(user.getEmail());//Логин и емайл одинаковы
        });
        assertEquals("Неправильный логин", loginIsSame2.getMessage());

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
