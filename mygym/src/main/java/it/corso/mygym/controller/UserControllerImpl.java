package it.corso.mygym.controller;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController{

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    @Override
    public ResponseEntity<User> save(UserDto dto) {
       User userSaved = userService.save(dto);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @Override

    public ResponseEntity<List<User>> findAll() {

        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.FOUND);
    }

    @Override
    @PostMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable long id,@RequestBody UserDto dto) {
        User user = userService.update(id, dto);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @Override
    public boolean deleteById(long id) {
        userService.deleteById(id);
        return true;
    }
}
