package org.example.Dao.Service;

import org.example.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    @DisplayName("Тестируем метод getUserByName из класса UserDaoImpl." +
            "1. Имя существует, приходит user" +
            "2. Имя не существует, приходит null ")
    void getUserByName() {
        User user1 = new User("1", "1@add.rt", "login1");
        assertEquals(user1, userDao.getUserByName("1"));
        assertNull(userDao.getUserByName("null"));
    }
}