package com.thafonsotest.users_api.controller;

import com.thafonsotest.users_api.dto.UserDTO;
import com.thafonsotest.users_api.entities.User;
import com.thafonsotest.users_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users") // path users
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(Pageable pageable) {
        List<UserDTO> userDTOS = userService.findAll();
        return ResponseEntity.ok().body(userDTOS); // return sucsess and the User List
    }

    @GetMapping(value = "/{id}") // path
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@Valid @RequestBody UserDTO userdto){
        UserDTO newUser = userService.insertUser(userdto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); // return empty response
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userdto){
        userService.updateUser(id, userdto);
        return ResponseEntity.ok().body(userdto);
    }
}
