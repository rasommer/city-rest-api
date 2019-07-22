package restapi.mapper;

import java.util.Collection;
import java.util.List;

import restapi.persistence.entity.City;
import restapi.web.dto.CityResponse;

public interface ICityMapper {

	CityResponse convertToCityResponse(City city);

	Collection<? extends CityResponse> convertToCitiesResponse(List<City> cities);

}
