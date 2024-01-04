package com.Revpay.FavePay.services;

import com.Revpay.FavePay.entities.User;
import com.Revpay.FavePay.exceptions.NoResultsException;
import com.Revpay.FavePay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public User findUserAndTasks(String username) throws NoResultsException {
//        User user = this.findByUsername(username);
//        Set<Task> tasks = taskService.findAllTasksForUser(user);
//        user.setTasks(tasks);
//        return user;
//    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public User saveUser (User user){
        return userRepository.save(user);
    }

    public Optional<User> getUsername (String username){
        return userRepository.findByUsername(username);
    }

    public User findByUsername (String username) throws NoResultsException {
        Optional<User> result = userRepository.findByUsername(username);
        if (result.isEmpty()) {
            throw new NoResultsException("No results for username: " + username);
        }
        return result.get();
    }

    public User findByUserId(Integer id) throws NoResultsException {
        Optional<User> result = userRepository.findById(id);
        if (result.isEmpty()) {
            throw new NoResultsException("No users found with ID: " + id);
        }
        return result.get();
    }


}
