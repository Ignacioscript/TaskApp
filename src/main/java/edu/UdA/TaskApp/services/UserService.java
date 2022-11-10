package edu.UdA.TaskApp.services;

import edu.UdA.TaskApp.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(Long id);

    User insert(User user);

    User updateUser(Long id, User user);

    boolean deleteUser(Long userId);
}
