package restapi.mapper;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restapi.persistence.entity.City;
import restapi.persistence.entity.Mesoregion;
import restapi.persistence.entity.Microregion;
import restapi.persistence.entity.State;
import restapi.persistence.repository.IMesoregionCrudRepository;
import restapi.persistence.repository.IMicroregionCrudRepository;
import restapi.persistence.repository.IStateCrudRepository;

@Component
public class CityFileMapper implements ICityFileMapper {

	public static String[] HEADERS = new String[] { "ibge_id", "uf", "name", "capital", "lon", "lat", "no_accents",
			"alternative_names", "microregion", "mesoregion" };

	@Autowired
	private IStateCrudRepository stateCrudRepository;

	@Autowired
	private IMicroregionCrudRepository microregionCrudRepository;

	@Autowired
	private IMesoregionCrudRepository mesoregionRepository;

	@Override
	public City convertToEntity(final CSVRecord csvRecord) {
		if (csvRecord == null) {
			return null;
		}
		final City city = new City();
		final String ibgeId = csvRecord.get(CityFileMapper.HEADERS[0]);
		final String uf = csvRecord.get(CityFileMapper.HEADERS[1]);
		final String name = csvRecord.get(CityFileMapper.HEADERS[2]);
		final String capital = csvRecord.get(CityFileMapper.HEADERS[3]);
		final String longitude = csvRecord.get(CityFileMapper.HEADERS[4]);
		final String latitude = csvRecord.get(CityFileMapper.HEADERS[5]);
		final String noAccents = csvRecord.get(CityFileMapper.HEADERS[6]);
		final String alternativeNames = csvRecord.get(CityFileMapper.HEADERS[7]);
		final String microregionName = csvRecord.get(CityFileMapper.HEADERS[8]);
		final String mesoregionName = csvRecord.get(CityFileMapper.HEADERS[9]);
		city.setIbgeID(Long.valueOf(ibgeId));
		final State state = this.getState(uf);
		city.setState(state);
		city.setName(name);
		city.setCapital(Boolean.valueOf(capital));
		city.setLongitude(Double.valueOf(longitude));
		city.setLatitude(Double.valueOf(latitude));
		city.setNoAccents(noAccents);
		city.setAlternativeNames(alternativeNames);
		final Microregion microregion = this.getMicroregion(microregionName);
		city.setMicroregion(microregion);
		final Mesoregion mesoregion = this.getMesoregion(mesoregionName);
		city.setMesoregion(mesoregion);
		return city;
	}

	private Mesoregion getMesoregion(final String mesoregionName) {
		final Mesoregion entity;
		final Mesoregion mesoregionByName = this.mesoregionRepository.findMesoregionByName(mesoregionName);
		if (mesoregionByName == null) {
			final Mesoregion mesoregion = new Mesoregion();
			mesoregion.setName(mesoregionName);
			entity = this.mesoregionRepository.save(mesoregion);
		} else {
			entity = mesoregionByName;
		}
		return entity;
	}

	private Microregion getMicroregion(final String microregionName) {
		final Microregion entity;
		final Microregion microregionByName = this.microregionCrudRepository.findMicroregionByName(microregionName);
		if (microregionByName == null) {
			final Microregion microregion = new Microregion();
			microregion.setName(microregionName);
			entity = this.microregionCrudRepository.save(microregion);
		} else {
			entity = microregionByName;
		}
		return entity;
	}

	private State getState(final String acronym) {
		State entity;
		final State stateByAcronym = this.stateCrudRepository.findStateByAcronym(acronym);
		if (stateByAcronym == null) {
			final State state = new State();
			state.setAcronym(acronym);
			entity = this.stateCrudRepository.save(state);
		} else {
			entity = stateByAcronym;
		}
		return entity;
	}

}
