package restapi.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import restapi.persistence.entity.City;
import restapi.web.dto.CityResponse;

@Component
public class CityMapper implements ICityMapper {

	@Override
	public Collection<? extends CityResponse> convertToCitiesResponse(final List<City> cities) {
		final List<CityResponse> citiesResponse = new ArrayList<>();
		cities.forEach(city -> {
			final CityResponse cityResponse = this.convertToCityResponse(city);
			citiesResponse.add(cityResponse);
		});
		return citiesResponse;
	}

	@Override
	public CityResponse convertToCityResponse(final City city) {
		if (city == null) {
			return null;
		}
		final CityResponse cityResponse = new CityResponse();
		final String alternativeNames = city.getAlternativeNames();
		cityResponse.setAlternativeNames(alternativeNames);
		final Boolean capital = city.getCapital();
		cityResponse.setCapital(capital.toString());
		final Long ibgeID = city.getIbgeID();
		cityResponse.setIbgeID(ibgeID.toString());
		final Double latitude = city.getLatitude();
		cityResponse.setLatitude(latitude.toString());
		final Double longitude = city.getLongitude();
		cityResponse.setLongitude(longitude.toString());
		final String mesoregion = city.getMesoregion().getName();
		cityResponse.setMesoregion(mesoregion);
		final String microregion = city.getMicroregion().getName();
		cityResponse.setMicroregion(microregion);
		final String name = city.getName();
		cityResponse.setName(name);
		final String noAccents = city.getNoAccents();
		cityResponse.setNoAccents(noAccents);
		final String acronym = city.getState().getAcronym();
		cityResponse.setState(acronym);
		return cityResponse;
	}

}
