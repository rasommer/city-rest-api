package restapi.service;

import java.io.IOException;
import java.util.Collection;

import org.springframework.web.multipart.MultipartFile;

import restapi.web.dto.CityDto;

public interface ICityFileService {

	Collection<? extends CityDto> loadCities(MultipartFile file) throws IOException;

}
