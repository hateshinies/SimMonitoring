package base.service;

import base.domain.SimInfo;

import java.util.List;

public interface SimInfoService {

    void save(SimInfo simInfo);

    SimInfo findSimInfoById(Long id);

    List<SimInfo> findAll();

    List<SimInfo> findByFunctioningTrue();

    void delete(Long id);

    //boolean exists(SimInfo simInfo);

}
