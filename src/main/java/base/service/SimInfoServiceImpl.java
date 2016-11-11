package base.service;

import base.domain.SimInfo;
import base.repository.SimInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("simInfoService")
@Transactional
public class SimInfoServiceImpl implements SimInfoService {

    @Autowired
    private SimInfoRepository simInfoRepository;

    @Override
    public List<SimInfo> findAll() {
        return simInfoRepository.findAll();
    }

    @Override
    public List<SimInfo> findByFuncTrue(){
        return simInfoRepository.findByFuncTrue();
    }

    @Override
    public void delete(Long id) {
        simInfoRepository.delete(id);
    }

    @Override
    public boolean exists(Long id) {
        return simInfoRepository.exists(id);
    }

    @Override
    public SimInfo getById(Long id) {
        return simInfoRepository.getOne(id);
    }

    @Override
    public void save(SimInfo simInfo) {
        simInfoRepository.save(simInfo);
    }



}
