package base.repository;


import base.domain.SimInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimInfoRepository extends JpaRepository<SimInfo, Long> {
}
