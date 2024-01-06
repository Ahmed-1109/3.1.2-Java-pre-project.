package com.ahmedmagomedov.demo_springboot.dao;

import com.ahmedmagomedov.demo_springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (Objects.isNull(user)) {
            throw new NullPointerException("в базе нет пользователя с  идентификатором " + id);
        } else {
            entityManager.remove(user);
        }
    }
}
