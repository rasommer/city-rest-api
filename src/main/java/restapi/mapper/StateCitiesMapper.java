package restapi.mapper;

import org.springframework.stereotype.Component;

import restapi.persistence.entity.State;
import restapi.web.dto.StateCitiesResponse;

@Component
public class StateCitiesMapper implements IStateCitiesMapper {

	@Override
	public StateCitiesResponse convertToResponse(final State state) {
		if (state == null) {
			return null;
		}
		final StateCitiesResponse stateCitiesResponse = new StateCitiesResponse();
		stateCitiesResponse.setAcronym(state.getAcronym());
		stateCitiesResponse.setCities(state.getCities().size());
		return stateCitiesResponse;
	}

}
