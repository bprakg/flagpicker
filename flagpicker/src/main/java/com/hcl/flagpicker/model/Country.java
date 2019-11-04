package com.hcl.flagpicker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(indexName = "continent", type = "_doc")
public class Country {

	@JsonIgnore
	private @Id String id;
	@JsonIgnore
	private String continent;
	private String country;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	private String flag;

	@Override
	public String toString() {
		return "Country [continent=" + continent + ", country=" + country + ", flag=" + flag + "]";
	}

}
