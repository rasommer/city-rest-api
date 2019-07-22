package restapi.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City {

	@Id
	@Column(name = "CITY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "CAPITAL", nullable = false)
	private Boolean capital;
	@Column(name = "LONGITUDE")
	private Double longitude;
	@Column(name = "LATITUDE")
	private Double latitude;
	@Column(name = "NO_ACCENTS")
	private String noAccents;
	@Column(name = "ALTERNATIVE_NAMES")
	private String alternativeNames;
	@Column(name = "IBGE_ID", nullable = false, unique = true)
	private Long ibgeID;
	@ManyToOne
	@JoinColumn(name = "STATE_ID", nullable = false)
	private State state;
	@ManyToOne
	@JoinColumn(name = "MICROREGION_ID", nullable = false)
	private Microregion microregion;
	@ManyToOne
	@JoinColumn(name = "MESOREGION_ID", nullable = false)
	private Mesoregion mesoregion;

	public String getAlternativeNames() {
		return this.alternativeNames;
	}

	public Boolean getCapital() {
		return this.capital;
	}

	public Long getIbgeID() {
		return this.ibgeID;
	}

	public Long getId() {
		return this.id;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public Mesoregion getMesoregion() {
		return this.mesoregion;
	}

	public Microregion getMicroregion() {
		return this.microregion;
	}

	public String getName() {
		return this.name;
	}

	public String getNoAccents() {
		return this.noAccents;
	}

	public State getState() {
		return this.state;
	}

	public void setAlternativeNames(final String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

	public void setCapital(final Boolean capital) {
		this.capital = capital;
	}

	public void setIbgeID(final Long ibgeID) {
		this.ibgeID = ibgeID;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}

	public void setMesoregion(final Mesoregion mesoregion) {
		this.mesoregion = mesoregion;
	}

	public void setMicroregion(final Microregion microregion) {
		this.microregion = microregion;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setNoAccents(final String noAccents) {
		this.noAccents = noAccents;
	}

	public void setState(final State state) {
		this.state = state;
	}
}
