package base.repository;


import base.domain.SimInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimInfoRepository extends JpaRepository<SimInfo, Long> {
    List<SimInfo> findByFunctioningTrue();
}
