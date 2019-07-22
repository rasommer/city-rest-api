package restapi.mapper;

import restapi.persistence.entity.State;
import restapi.web.dto.StateCitiesResponse;

public interface IStateCitiesMapper {

	StateCitiesResponse convertToResponse(State state);

}
