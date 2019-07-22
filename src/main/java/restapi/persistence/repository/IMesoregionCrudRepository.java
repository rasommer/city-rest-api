package restapi.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import restapi.persistence.entity.Mesoregion;

public interface IMesoregionCrudRepository extends CrudRepository<Mesoregion, Long> {

	@Query("SELECT m FROM Mesoregion m WHERE m.name = :name")
	Mesoregion findMesoregionByName(@Param("name") String name);
}
