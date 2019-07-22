package restapi.web.dto;

import java.util.ArrayList;
import java.util.List;

public class StatesMaxMinResponse {

	private List<StateMaxMinResponse> statesMax = new ArrayList<>();

	private List<StateMaxMinResponse> statesMin = new ArrayList<>();

	public List<StateMaxMinResponse> getStatesMax() {
		return this.statesMax;
	}

	public List<StateMaxMinResponse> getStatesMin() {
		return this.statesMin;
	}

	public void setStatesMax(final List<StateMaxMinResponse> statesMax) {
		this.statesMax = statesMax;
	}

	public void setStatesMin(final List<StateMaxMinResponse> statesMin) {
		this.statesMin = statesMin;
	}

}
