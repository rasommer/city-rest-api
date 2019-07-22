package restapi.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import restapi.persistence.entity.Microregion;

public interface IMicroregionCrudRepository extends CrudRepository<Microregion, Long> {

	@Query("SELECT m FROM Microregion m WHERE m.name = :name")
	Microregion findMicroregionByName(@Param("name") String name);
}
