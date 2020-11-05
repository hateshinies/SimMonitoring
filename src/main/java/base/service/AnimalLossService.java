package base.service;

import base.domain.AnimalLoss;
import java.util.List;

public interface AnimalLossService {

    void save(AnimalLoss animalLoss);

    AnimalLoss getById(Long id);

    List<AnimalLoss> findAll();

    //void delete(Long id);

    //boolean exists(Long id);

    void addEntry(AnimalLoss animalLoss);
}
