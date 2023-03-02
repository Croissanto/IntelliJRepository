package it.corso.mygym.service;

import it.corso.mygym.model.User;
import it.corso.mygym.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findById(Long id) {

        Optional<User> opt = userRepo.findById(id);
        if (opt.isPresent()) {

            return opt.get();

        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            userRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
