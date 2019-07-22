package restapi.mapper;

import restapi.persistence.entity.City;
import restapi.web.dto.CityDto;

public interface ICityMapper {

	CityDto convertToDto(City city);

}
