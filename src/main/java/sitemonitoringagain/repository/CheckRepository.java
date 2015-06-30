package sitemonitoringagain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sitemonitoringagain.entity.Check;

public interface CheckRepository extends JpaRepository<Check, Integer>{

}
