package it.corso.mygym.controller;


import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserController {


    @PostMapping()
    ResponseEntity<User> save(@RequestBody UserDto dto);

    @GetMapping("/{id}")
    ResponseEntity<User> findById(@PathVariable long id);

    @GetMapping("/all")
    ResponseEntity<List<User>> findAll();

    @PostMapping("/update/{id}")
    ResponseEntity<User> update(@PathVariable long id, UserDto dto);

    @DeleteMapping("/{id}")
    boolean deleteById(@PathVariable long id);

}
