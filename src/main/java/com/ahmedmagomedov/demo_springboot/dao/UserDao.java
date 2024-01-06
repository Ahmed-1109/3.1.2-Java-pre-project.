package com.ahmedmagomedov.demo_springboot.dao;



import com.ahmedmagomedov.demo_springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();

    void addUser(User user);

    User getUserById(Long id);

    void delete(Long id);

}
