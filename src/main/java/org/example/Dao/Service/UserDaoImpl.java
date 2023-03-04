package org.example.Dao.Service;

import org.example.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserDaoImpl {

    List<User> list = new ArrayList<>();

    User user1 = new User("1", "1@add.rt", "login1");
    User user2 = new User("2", "2@add.rt", "login2");
    User user3 = new User("3", "3@add.rt", "login3");
    User user4 = new User("4", "4@add.rt", "login4");
    User user5 = new User("5", "5@add.rt", "login5");

    public UserDaoImpl() {
        Collections.addAll(list, user1, user2, user3, user4, user5);
    }

    public User getUserByName(String name) {
        for (User user : list) {
            if (user.getName().equals(name)) {
                return user;
            }

        }
        return null;
    }

    public List<User> findAllUsers() {
        return list;
    }


}
