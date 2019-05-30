package core.service;

import core.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User updateUser(Long userId, String username, String password, String firstName, String lastName, Boolean isAdmin);

    User saveUser(User user);

    void deleteUser(Long userId);

}
