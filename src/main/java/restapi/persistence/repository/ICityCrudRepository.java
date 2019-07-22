package restapi.persistence.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import restapi.persistence.entity.City;
import restapi.persistence.entity.State;

public interface ICityCrudRepository extends CrudRepository<City, Long> {

	@Query("SELECT c FROM City c WHERE c.capital = TRUE ORDER BY c.name")
	List<City> findCapitalsOrderByName();

	@Query("SELECT c FROM City c WHERE c.ibgeID = :ibgeID")
	City findCityByIbgeID(@Param("ibgeID") Long ibgeID);

	@Query("SELECT c FROM City c WHERE UPPER(c.state) = UPPER(:state)")
	Collection<? extends City> findCityByState(@Param("state") State state);
}
