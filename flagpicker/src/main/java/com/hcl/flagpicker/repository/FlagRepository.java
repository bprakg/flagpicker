package com.hcl.flagpicker.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.hcl.flagpicker.model.Country;

public interface FlagRepository extends Repository<Country, String> {
	List<Country> findByContinent(String continent);

	List<Country> findByContinentOrCountry(String continent, String country);
}
