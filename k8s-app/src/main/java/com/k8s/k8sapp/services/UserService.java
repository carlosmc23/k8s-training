package com.k8s.k8sapp.services;

import com.k8s.k8sapp.model.User;
import com.k8s.k8sapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User addNewUser(String name, String lastName, String role) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setLastName(lastName);
        newUser.setRole(role);
        return userRepository.save(newUser);
    }

    public User updateUserInfo(Long id, String name, String lastName, String role) {
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setName(name);
        userToUpdate.setLastName(lastName);
        userToUpdate.setRole(role);
        return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
