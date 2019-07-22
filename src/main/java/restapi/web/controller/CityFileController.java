package restapi.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import restapi.service.ICityFileService;
import restapi.web.dto.CityResponse;

@RestController
public class CityFileController {

	@Autowired
	private ICityFileService cityFileService;

	@PostMapping("/load-cities")
	public List<CityResponse> loadCityFile(@RequestParam("csv") final MultipartFile file) throws IOException {
		final List<CityResponse> cities = new ArrayList<>();
		cities.addAll(this.cityFileService.loadCities(file));
		return cities;
	}

}
