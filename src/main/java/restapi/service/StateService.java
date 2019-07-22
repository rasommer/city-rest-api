package restapi.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restapi.mapper.IStateCitiesMapper;
import restapi.mapper.IStateMaxMinMapper;
import restapi.persistence.entity.State;
import restapi.persistence.repository.IStateCrudRepository;
import restapi.web.dto.StateCitiesResponse;
import restapi.web.dto.StateMaxMinResponse;
import restapi.web.dto.StatesMaxMinResponse;

@Service
public class StateService implements IStateService {

	@Autowired
	private IStateCrudRepository stateCrudRepository;

	@Autowired
	private IStateMaxMinMapper stateMaxMinMapper;

	@Autowired
	private IStateCitiesMapper stateCitiesMapper;

	private List<State> getInvertedSortedStates(final List<State> states) {
		final List<State> sortedList = new ArrayList<>(states);
		Collections.sort(sortedList, new Comparator<State>() {

			@Override
			public int compare(final State first, final State second) {
				final int firstSize = first.getCities().size();
				final int secondSize = second.getCities().size();
				return secondSize - firstSize;
			}
		});
		return sortedList;
	}

	private List<State> getSortedStates(final List<State> states) {
		final List<State> sortedList = new ArrayList<>(states);
		Collections.sort(sortedList, new Comparator<State>() {

			@Override
			public int compare(final State first, final State second) {
				final int firstSize = first.getCities().size();
				final int secondSize = second.getCities().size();
				return firstSize - secondSize;
			}
		});
		return sortedList;
	}

	@Override
	public Collection<? extends StateCitiesResponse> getStateCities() {
		final List<StateCitiesResponse> stateCitiesResponses = new ArrayList<>();
		final Iterable<State> all = this.stateCrudRepository.findAll();
		all.forEach(state -> {
			final StateCitiesResponse response = this.stateCitiesMapper.convertToResponse(state);
			stateCitiesResponses.add(response);
		});
		return stateCitiesResponses;
	}

	private List<StateMaxMinResponse> getStatesMax(final List<State> states) {
		final List<StateMaxMinResponse> statesMax = new ArrayList<>();
		final List<State> invertedSortedStates = this.getInvertedSortedStates(states);
		final State firstState = invertedSortedStates.remove(0);
		final StateMaxMinResponse firstMax = this.stateMaxMinMapper.convertToResponse(firstState);
		statesMax.add(firstMax);
		final Integer maxCityQuantity = firstMax.getCityQuantity();
		for (final State state : invertedSortedStates) {
			final int citiesSize = state.getCities().size();
			if (citiesSize == maxCityQuantity) {
				final StateMaxMinResponse response = this.stateMaxMinMapper.convertToResponse(state);
				statesMax.add(response);
			} else {
				break;
			}
		}
		return statesMax;
	}

	@Override
	public StatesMaxMinResponse getStatesMaxMin() {
		final StatesMaxMinResponse response = new StatesMaxMinResponse();
		final List<State> states = new ArrayList<>();
		final Iterable<State> all = this.stateCrudRepository.findAll();
		all.forEach(states::add);
		final List<StateMaxMinResponse> statesMax = this.getStatesMax(states);
		response.setStatesMax(statesMax);
		final List<StateMaxMinResponse> statesMin = this.getStatesMin(states);
		response.setStatesMin(statesMin);
		return response;
	}

	private List<StateMaxMinResponse> getStatesMin(final List<State> states) {
		final List<StateMaxMinResponse> statesMin = new ArrayList<>();
		final List<State> sortedStates = this.getSortedStates(states);
		final State firstState = sortedStates.remove(0);
		final StateMaxMinResponse firstMin = this.stateMaxMinMapper.convertToResponse(firstState);
		statesMin.add(firstMin);
		final Integer maxCityQuantity = firstMin.getCityQuantity();
		for (final State state : sortedStates) {
			final int citiesSize = state.getCities().size();
			if (citiesSize == maxCityQuantity) {
				final StateMaxMinResponse response = this.stateMaxMinMapper.convertToResponse(state);
				statesMin.add(response);
			} else {
				break;
			}
		}
		return statesMin;
	}
}
