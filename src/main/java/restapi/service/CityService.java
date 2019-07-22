package restapi.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restapi.mapper.ICityMapper;
import restapi.persistence.entity.City;
import restapi.persistence.entity.State;
import restapi.persistence.repository.ICityCrudRepository;
import restapi.persistence.repository.IStateCrudRepository;
import restapi.web.dto.CityResponse;

@Service
public class CityService implements ICityService {

	@Autowired
	private ICityCrudRepository cityCrudRepository;

	@Autowired
	private IStateCrudRepository stateCrudRepository;

	@Autowired
	private ICityMapper cityMapper;

	@Override
	public Collection<? extends CityResponse> getCapitalsOrderByName() {
		final List<CityResponse> citiesResponse = new ArrayList<>();
		final List<City> cities = this.cityCrudRepository.findCapitalsOrderByName();
		citiesResponse.addAll(this.cityMapper.convertToCitiesResponse(cities));
		return citiesResponse;
	}

	@Override
	public Collection<? extends CityResponse> getCitiesByState(final String acronym) {
		final List<CityResponse> citiesResponse = new ArrayList<>();
		final List<City> cities = new ArrayList<>();
		final State state = this.stateCrudRepository.findStateByAcronym(acronym);
		cities.addAll(this.cityCrudRepository.findCityByState(state));
		cities.forEach(city -> {
			final CityResponse cityResponse = this.cityMapper.convertToCityResponse(city);
			citiesResponse.add(cityResponse);
		});
		return citiesResponse;
	}

	@Override
	public CityResponse getCityByIbge(final Long ibgeID) {
		final City cityByIbgeID = this.cityCrudRepository.findCityByIbgeID(ibgeID);
		final CityResponse cityResponse = this.cityMapper.convertToCityResponse(cityByIbgeID);
		return cityResponse;
	}

}
