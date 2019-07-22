package restapi.mapper;

import org.springframework.stereotype.Component;

import restapi.persistence.entity.City;
import restapi.web.dto.CityDto;

@Component
public class CityMapper implements ICityMapper {

	@Override
	public CityDto convertToDto(final City city) {
		final CityDto cityDto = new CityDto();
		final String alternativeNames = city.getAlternativeNames();
		cityDto.setAlternativeNames(alternativeNames);
		final Boolean capital = city.getCapital();
		cityDto.setCapital(capital.toString());
		final Long ibgeID = city.getIbgeID();
		cityDto.setIbgeID(ibgeID.toString());
		final Double latitude = city.getLatitude();
		cityDto.setLatitude(latitude.toString());
		final Double longitude = city.getLongitude();
		cityDto.setLongitude(longitude.toString());
		final String mesoregion = city.getMesoregion().getName();
		cityDto.setMesoregion(mesoregion);
		final String microregion = city.getMicroregion().getName();
		cityDto.setMicroregion(microregion);
		final String name = city.getName();
		cityDto.setName(name);
		final String noAccents = city.getNoAccents();
		cityDto.setNoAccents(noAccents);
		final String acronym = city.getState().getAcronym();
		cityDto.setState(acronym);
		return cityDto;
	}

}
