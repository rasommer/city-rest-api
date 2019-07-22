package restapi.mapper;

import restapi.persistence.entity.State;
import restapi.web.dto.StateMaxMinResponse;

public interface IStateMaxMinMapper {

	StateMaxMinResponse convertToResponse(State state);

}
