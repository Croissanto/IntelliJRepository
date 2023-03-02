package it.corso.mygym.service;

import it.corso.mygym.model.GymStructure;
import it.corso.mygym.model.dto.GymStructureDto;
import it.corso.mygym.repositories.GymStructureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GymStructureServiceImpls implements GymStructureService {

    @Autowired
    private GymStructureRepository gymRepo;

    @Override
    public GymStructure save(GymStructureDto dto) {
        ModelMapper mapper = new ModelMapper();
        GymStructure gym = mapper.map(dto, GymStructure.class);
        return gymRepo.save(gym);
    }

    @Override
    public GymStructure findById(long id) {
        Optional<GymStructure> opt = gymRepo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public boolean deleteById(long id) {
        try {
            gymRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public GymStructure update(long id, GymStructureDto dto) {
        Optional<GymStructure> opt = gymRepo.findById(id);
        dto.setId(id);
        if (opt.isPresent()) {
            GymStructure gymStructure = opt.get();
            dto.setId(id);
            return gymRepo.saveAndFlush(gymStructure);

        } else throw new ResourceNotFoundException();
    }
}
