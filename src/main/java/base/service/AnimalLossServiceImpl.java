package base.service;

import base.domain.AnimalLoss;
import base.repository.AnimalLossRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("animalLossService")
@Transactional
public class AnimalLossServiceImpl implements AnimalLossService {

    @Autowired
    private AnimalLossRepository animalLossRepository;

    @Override
    public List<AnimalLoss> findAll() {
        return animalLossRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        animalLossRepository.delete(id);
    }

    @Override
    public boolean exists(Long id) {
        return animalLossRepository.exists(id);
    }

    @Override
    public AnimalLoss getById(Long id) {
        return animalLossRepository.getOne(id);
    }

    @Override
    public void save(AnimalLoss animalLoss) {
        animalLossRepository.save(animalLoss);
    }

}
