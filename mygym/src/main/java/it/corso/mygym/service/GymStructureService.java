package it.corso.mygym.service;

import it.corso.mygym.model.GymStructure;
import it.corso.mygym.model.dto.GymStructureDto;

public interface GymStructureService {

    GymStructure save(GymStructureDto dto);

    GymStructure findById(long id);

    boolean deleteById(long id);

    GymStructure update(long id, GymStructureDto dto);
}
