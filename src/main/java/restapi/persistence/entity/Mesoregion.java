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
@Table(name = "MESOREGION")
public class Mesoregion {

	@Id
	@Column(name = "MESOREGION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "NAME", nullable = false, unique = true)
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mesoregion")
	private List<City> cities;

	public List<City> getCities() {
		return this.cities;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setCities(final List<City> cities) {
		this.cities = cities;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
