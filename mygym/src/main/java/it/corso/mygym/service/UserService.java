package it.corso.mygym.service;

import it.corso.mygym.model.User;

public interface UserService {

    User save(User user);

    User findById(Long id);

    boolean deleteById(Long id);
}
