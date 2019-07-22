package restapi.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STATE")
public class State {

	@Id
	@Column(name = "STATE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "ACRONYM", nullable = false, unique = true)
	private String acronym;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	private List<City> cities;

	public String getAcronym() {
		return this.acronym;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public Long getId() {
		return this.id;
	}

	public void setAcronym(final String acronym) {
		this.acronym = acronym;
	}

	public void setCities(final List<City> cities) {
		this.cities = cities;
	}

	public void setId(final Long id) {
		this.id = id;
	}
}
