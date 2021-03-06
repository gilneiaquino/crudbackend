package br.com.crudbackend.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.crudbackend.dto.EnderecoFormAlteracao;
import br.com.crudbackend.dto.EnderecoFormInclusao;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String streetName;
	private Long number;
	private String complement;
	private String neighbourhood;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String latitude;
	private String longitude;
	
	public Endereco() {
		super();
	}	

	public Endereco(Long id, String streetName, Long number, String complement, String neighbourhood, String city,
			String state, String country, String zipcode, String latitude, String longitude) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.number = number;
		this.complement = complement;
		this.neighbourhood = neighbourhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Endereco(EnderecoFormInclusao formInclusao) {
		super(); 
		this.id = 0L;
		this.streetName = formInclusao.getStreetName();
		this.number = formInclusao.getNumber();
		this.complement = formInclusao.getComplement();
		this.neighbourhood = formInclusao.getNeighbourhood();
		this.city = formInclusao.getCity();
		this.state = formInclusao.getState();
		this.country = formInclusao.getState();
		this.zipcode = formInclusao.getZipcode();
		this.latitude = formInclusao.getLatitude();
		this.longitude = formInclusao.getLongitude();
	}
	
	public Endereco(EnderecoFormAlteracao formInclusao) {
		super(); 
		this.id = formInclusao.getId(); 
		this.streetName = formInclusao.getStreetName();
		this.number = formInclusao.getNumber();
		this.complement = formInclusao.getComplement();
		this.neighbourhood = formInclusao.getNeighbourhood();
		this.city = formInclusao.getCity();
		this.state = formInclusao.getState();
		this.country = formInclusao.getState();
		this.zipcode = formInclusao.getZipcode();
		this.latitude = formInclusao.getLatitude();
		this.longitude = formInclusao.getLongitude();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
