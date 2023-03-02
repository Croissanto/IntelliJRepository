package it.corso.mygym.controller;
import it.corso.mygym.model.User;
import it.corso.mygym.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/getallusers")
    public List<User> getUsers() {

        Iterable<User> it = userRepo.findAll();
        List<User> list = new LinkedList<>();
        for (User user : it) {
            list.add(user);

        }
        return list;

    }

    @GetMapping("/getuserscertified")
    public List<User> getUsersCertified() {

        Iterable<User> it = userRepo.findByCertifiedMedicallyTrue();
        List<User> list = new LinkedList<>();
        for (User user : it) {
            list.add(user);

        }
        return list;

    }

}
