package edu.UdA.TaskApp.services;



import edu.UdA.TaskApp.models.User;
import edu.UdA.TaskApp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User userFromDB = userRepository.findById(id).get();
        System.out.println(userFromDB.toString());
        userFromDB.setProfile(user.getProfile());
        userFromDB.setEmail(user.getEmail());
        userFromDB.setTask(user.getTask());
        userRepository.save(userFromDB);

    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }
}
