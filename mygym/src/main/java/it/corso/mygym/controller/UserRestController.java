package it.corso.mygym.controller;
import it.corso.mygym.model.User;
import it.corso.mygym.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/getallusers")
    public List<User> getAllUsers() {


        return userRepo.findAll();

    }

}
