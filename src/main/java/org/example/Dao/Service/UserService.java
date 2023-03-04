package org.example.Dao.Service;

import org.example.User;

import java.util.ArrayList;

public class UserService {
    UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserExist(User user) {
        return userDao.getUserByName(user.getName()) != null;
    }
}
