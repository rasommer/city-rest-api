package restapi.service;

import java.io.IOException;
import java.util.Collection;

import org.springframework.web.multipart.MultipartFile;

import restapi.web.dto.CityResponse;

public interface ICityFileService {

	Collection<? extends CityResponse> loadCities(MultipartFile file) throws IOException;

}
