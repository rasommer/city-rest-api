package restapi.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import restapi.service.IStateService;
import restapi.web.dto.StateCitiesResponse;
import restapi.web.dto.StatesMaxMinResponse;

@RestController
public class StateController {

	@Autowired
	private IStateService stateService;

	@GetMapping("/state-cities")
	public List<StateCitiesResponse> getStateCities() {
		final List<StateCitiesResponse> stateCitiesResponses = new ArrayList<>();
		stateCitiesResponses.addAll(this.stateService.getStateCities());
		return stateCitiesResponses;
	}

	@GetMapping("/state-max-min")
	public StatesMaxMinResponse getStatesMaxMin() {
		final StatesMaxMinResponse response = this.stateService.getStatesMaxMin();
		return response;
	}
}
