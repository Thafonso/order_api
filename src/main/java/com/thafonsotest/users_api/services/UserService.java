package com.thafonsotest.users_api.services;

import com.thafonsotest.users_api.entities.User;
import com.thafonsotest.users_api.repositories.UserRepository;
import com.thafonsotest.users_api.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        User u = userRepository.getReferenceById(id); // search by id and update the user who has this id
        updateData(u, user);
        return userRepository.save(u);
    }

    private void updateData(User u, User user) {
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPhone(user.getPhone());
    }
}

