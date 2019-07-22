package restapi.web.dto;

public class CityDto {

	private String name;
	private String capital;
	private String longitude;
	private String latitude;
	private String noAccents;
	private String alternativeNames;
	private String ibgeID;
	private String state;
	private String microregion;
	private String mesoregion;

	public String getAlternativeNames() {
		return this.alternativeNames;
	}

	public String getCapital() {
		return this.capital;
	}

	public String getIbgeID() {
		return this.ibgeID;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public String getMesoregion() {
		return this.mesoregion;
	}

	public String getMicroregion() {
		return this.microregion;
	}

	public String getName() {
		return this.name;
	}

	public String getNoAccents() {
		return this.noAccents;
	}

	public String getState() {
		return this.state;
	}

	public void setAlternativeNames(final String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

	public void setCapital(final String capital) {
		this.capital = capital;
	}

	public void setIbgeID(final String ibgeID) {
		this.ibgeID = ibgeID;
	}

	public void setLatitude(final String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(final String longitude) {
		this.longitude = longitude;
	}

	public void setMesoregion(final String mesoregion) {
		this.mesoregion = mesoregion;
	}

	public void setMicroregion(final String microregion) {
		this.microregion = microregion;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setNoAccents(final String noAccents) {
		this.noAccents = noAccents;
	}

	public void setState(final String state) {
		this.state = state;
	}

}
