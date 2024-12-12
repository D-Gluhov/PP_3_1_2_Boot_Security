package ru.kata.spring.boot_security.demo.service;

import org.springframework.ui.Model;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    void delete(int id);

    void validateUserId(Integer id, Model model);
}
