package org.example.Dao.Service;

import org.example.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserDaoImpl userDaoMock;
    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.initMocks(this);

    }

    User user1 = new User("1", "1@add.rt", "login1");


    @Test
    @DisplayName("Тестируем метод checkUserExist из класса UserService" +
            "Вставляем user, ожидаем true")
    void checkUserExistShouldTrue() {
        when(userDaoMock.getUserByName(anyString())).thenReturn(new User());
        assertTrue(userService.checkUserExist(user1));
    }

    @Test
    @DisplayName("Тестируем метод checkUserExist из класса UserService" +
            "Вставляем user, ожидаем false")
    void checkUserExistShouldFalse() {
        when(userDaoMock.getUserByName(anyString())).thenReturn(null);
        assertFalse(userService.checkUserExist(user1));
    }
}