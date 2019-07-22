package restapi.web.dto;

public class StateMaxMinResponse {

	private String acronym;
	private Integer cityQuantity;

	public String getAcronym() {
		return this.acronym;
	}

	public Integer getCityQuantity() {
		return this.cityQuantity;
	}

	public void setAcronym(final String acronym) {
		this.acronym = acronym;
	}

	public void setCityQuantity(final Integer cityQuantity) {
		this.cityQuantity = cityQuantity;
	}
}
