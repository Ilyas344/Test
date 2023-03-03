package org.example;

import java.util.Objects;

public class User {


    private String login;
    private String email;

    public User() {
    }

    public User(String email, String login) {
        if (email.equals(login)) {
            throw new RuntimeException("Емайл равен логину");
        } else {
            setEmail(email);
            setLogin(login);
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty() || email.equals(login)) {
            throw new RuntimeException("Неправильный емайл");
        }
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            throw new RuntimeException("Неправильный емайл");
        }


    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.isEmpty() || email.equals(login)) {
            throw new RuntimeException("Неправильный логин");
        }
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }

}
