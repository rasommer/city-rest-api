package restapi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restapi.persistence.entity.City;

public interface ICityRepository extends JpaRepository<City, Long> {

}
