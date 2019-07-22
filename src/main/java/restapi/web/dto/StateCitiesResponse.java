package restapi.web.dto;

public class StateCitiesResponse {

	private String acronym;

	private Integer cities;

	public String getAcronym() {
		return this.acronym;
	}

	public Integer getCities() {
		return this.cities;
	}

	public void setAcronym(final String acronym) {
		this.acronym = acronym;
	}

	public void setCities(final Integer cities) {
		this.cities = cities;
	}

}
