package it.corso.mygym.service;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public User save(UserDto dto) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(dto, User.class);
        return userRepo.save(user);
    }

    @Override
    public User findById(long id) {

        Optional<User> opt = userRepo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public boolean deleteById(long id) {
        try {
            userRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User update(long id, UserDto dto) {
        Optional<User> opt = userRepo.findById(id);
        if(opt.isPresent()) {
        User user = opt.get();
            user.setName(dto.getName());
            user.setSurname(dto.getSurname());
            user.setEmail(dto.getEmail());
            user.setBirthDay(dto.getBirthDay());
            user.setCertifiedMedically(dto.isCertifiedMedically());
            user.setActiveFlag(dto.isActiveFlag());
        return userRepo.saveAndFlush(user);

        }

         else throw new ResourceNotFoundException();
    }


}
