package restapi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import restapi.service.ICityService;

@RestController
public class CityController {

	@Autowired
	private ICityService cityService;

}
