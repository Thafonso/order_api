package com.thafonsotest.users_api.services;

import com.thafonsotest.users_api.dto.UserDTO;
import com.thafonsotest.users_api.entities.User;
import com.thafonsotest.users_api.repositories.UserRepository;
import com.thafonsotest.users_api.services.exceptions.DataBaseException;
import com.thafonsotest.users_api.services.exceptions.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return new UserDTO(user);
    }

    public UserDTO insertUser(UserDTO userdto) {
        User user = fromDTO(userdto);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    public void deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
        } catch(NotFoundException e){
            throw new NotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public UserDTO updateUser(Long id, UserDTO userdto) {
        try {
            User u = userRepository.getReferenceById(id); // search by id and update the user who has this id
            updateData(u, userdto);
            userRepository.save(u);
            return new UserDTO(u);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(id);
        }
    }

    private void updateData(User u, UserDTO userdto) {
        u.setName(userdto.getName());
        u.setEmail(userdto.getEmail());
        u.setPhone(userdto.getPhone());
    }

    private User fromDTO(UserDTO userdto) {
        User user = new User();
        user.setID(userdto.getId());
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setPhone(userdto.getPhone());
        return user;
    }
}

