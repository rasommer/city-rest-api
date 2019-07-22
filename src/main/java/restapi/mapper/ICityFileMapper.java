package restapi.mapper;

import org.apache.commons.csv.CSVRecord;

import restapi.persistence.entity.City;

public interface ICityFileMapper {

	City convertToEntity(CSVRecord csvRecord);

}
