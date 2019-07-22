package restapi.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restapi.service.ICityService;
import restapi.web.dto.CityResponse;

@RestController
public class CityController {

	@Autowired
	private ICityService cityService;

	@GetMapping("/capital-order-by-name")
	public List<CityResponse> getCapitalsOrderByName() {
		final List<CityResponse> cities = new ArrayList<>();
		cities.addAll(this.cityService.getCapitalsOrderByName());
		return cities;
	}

	@GetMapping("/city-by-ibge")
	public CityResponse getCityByIbge(@RequestParam("ibge_id") final Long ibgeId) {
		final CityResponse cityResponse = this.cityService.getCityByIbge(ibgeId);
		return cityResponse;
	}

	@GetMapping("/cities-by-state")
	public List<CityResponse> getCityByState(@RequestParam("state") final String acronym) {
		final List<CityResponse> citiesResponse = new ArrayList<>();
		citiesResponse.addAll(this.cityService.getCitiesByState(acronym));
		return citiesResponse;
	}
}
