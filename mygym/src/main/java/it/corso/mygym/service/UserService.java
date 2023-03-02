package it.corso.mygym.service;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;

public interface UserService {

    User save(UserDto user);

    User findById(long id);

    boolean deleteById(long id);

    User update(long id, UserDto user);
}
