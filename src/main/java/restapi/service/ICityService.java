package restapi.service;

import java.util.Collection;

import restapi.web.dto.CityResponse;

public interface ICityService {

	Collection<? extends CityResponse> getCapitalsOrderByName();

	CityResponse getCityByIbge(Long ibgeId);

	Collection<? extends CityResponse> getCitiesByState(String acronym);

}
