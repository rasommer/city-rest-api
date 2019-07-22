package restapi.mapper;

import org.springframework.stereotype.Component;

import restapi.persistence.entity.State;
import restapi.web.dto.StateMaxMinResponse;

@Component
public class StateMaxMinMapper implements IStateMaxMinMapper {

	@Override
	public StateMaxMinResponse convertToResponse(final State state) {
		if (state == null) {
			return null;
		}
		final StateMaxMinResponse stateMaxMinResponse = new StateMaxMinResponse();
		stateMaxMinResponse.setAcronym(state.getAcronym());
		final int citiesSize = state.getCities().size();
		stateMaxMinResponse.setCityQuantity(citiesSize);
		return stateMaxMinResponse;
	}

}
