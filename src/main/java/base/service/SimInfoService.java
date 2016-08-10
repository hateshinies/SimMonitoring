package base.service;

import base.domain.SimInfo;

import java.util.List;

public interface SimInfoService {

    void save(SimInfo simInfo);

    SimInfo getById(Long id);

    List<SimInfo> findAll();

    void delete(Long id);

    boolean exists(Long id);
}
