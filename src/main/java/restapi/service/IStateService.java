package restapi.service;

import java.util.Collection;

import restapi.web.dto.StateCitiesResponse;
import restapi.web.dto.StatesMaxMinResponse;

public interface IStateService {

	Collection<? extends StateCitiesResponse> getStateCities();

	StatesMaxMinResponse getStatesMaxMin();
}
