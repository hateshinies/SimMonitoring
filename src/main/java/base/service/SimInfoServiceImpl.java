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
    public List<SimInfo> findByFunctioningTrue() {
        return simInfoRepository.findByFunctioningTrue();
    }

    public void delete(Long id) {
        simInfoRepository.deleteSimInfoById(id);
    }

    public SimInfo findSimInfoById(Long id) {
        return simInfoRepository.getOne(id);
    }

    @Override
    public void save(SimInfo simInfo) {
        simInfoRepository.save(simInfo);
    }

/*    @Override
    public boolean exists(SimInfo simInfo) {
        return simInfoRepository.exists(simInfo);
    }*/
}
