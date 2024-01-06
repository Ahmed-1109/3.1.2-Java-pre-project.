package com.ahmedmagomedov.demo_springboot.service;



import com.ahmedmagomedov.demo_springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();

    void addUser(User user);

    User getUserById(Long id);

    void delete(Long id);

}
