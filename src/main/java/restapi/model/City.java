package restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City {

	@Id
	@Column(name = "CITY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CAPITAL")
	private Boolean capital;
	@Column(name = "LONGITUDE")
	private Double longitude;
	@Column(name = "LATITUDE")
	private Double latitude;
	@Column(name = "NO_ACCENTS")
	private String noAccents;
	@Column(name = "ALTERNATIVE_NAMES")
	private String alternativeNames;
	@Column(name = "IBGE_ID")
	private Long ibgeID;
	@ManyToOne
	private State state;
	@ManyToOne
	private Microregion microregion;
	@ManyToOne
	private Mesoregion mesoregion;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIbgeID() {
		return this.ibgeID;
	}

	public void setIbgeID(Long ibgeID) {
		this.ibgeID = ibgeID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCapital() {
		return this.capital;
	}

	public void setCapital(Boolean capital) {
		this.capital = capital;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getNoAccents() {
		return this.noAccents;
	}

	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}

	public String getAlternativeNames() {
		return this.alternativeNames;
	}

	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Microregion getMicroregion() {
		return this.microregion;
	}

	public void setMicroregion(Microregion microregion) {
		this.microregion = microregion;
	}

	public Mesoregion getMesoregion() {
		return this.mesoregion;
	}

	public void setMesoregion(Mesoregion mesoregion) {
		this.mesoregion = mesoregion;
	}
}
