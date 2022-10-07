package ru.vickamams.spring.mvc_hibernate_aop.dao;

import ru.vickamams.spring.mvc_hibernate_aop.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public void saveUser(User employee);

    User getUser(int id);

    void deleteUser(int id);
}
