package restapi.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import restapi.mapper.CityFileMapper;
import restapi.mapper.ICityFileMapper;
import restapi.mapper.ICityMapper;
import restapi.persistence.entity.City;
import restapi.persistence.repository.ICityRepository;
import restapi.web.dto.CityDto;

@Service
public class CityFileService implements ICityFileService {

	@Autowired
	private ICityFileMapper cityFileMapper;
	@Autowired
	private ICityRepository cityRepository;
	@Autowired
	private ICityMapper cityMapper;

	@Override
	public Collection<? extends CityDto> loadCities(final MultipartFile file) throws IOException {
		final List<CityDto> citiesDto = new ArrayList<>();
		final InputStream inputStream = file.getInputStream();
		final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		final CSVParser csvParser = CSVFormat.EXCEL.withHeader(CityFileMapper.HEADERS).withFirstRecordAsHeader()
				.parse(inputStreamReader);
		csvParser.forEach((csvRecord) -> {
			final City city = this.cityFileMapper.convertToEntity(csvRecord);
			final City entity = this.cityRepository.save(city);
			final CityDto cityDto = this.cityMapper.convertToDto(entity);
			citiesDto.add(cityDto);
		});
		return citiesDto;
	}

}
