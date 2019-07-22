package restapi.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import restapi.persistence.entity.State;

public interface IStateCrudRepository extends CrudRepository<State, Long> {

	@Query("SELECT s FROM State s WHERE UPPER(s.acronym) = UPPER(:acronym)")
	State findStateByAcronym(@Param("acronym") String acronym);
}
