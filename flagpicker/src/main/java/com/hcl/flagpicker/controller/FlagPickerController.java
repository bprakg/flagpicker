package com.hcl.flagpicker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flagpicker.model.Country;
import com.hcl.flagpicker.repository.FlagRepository;

@RestController
@RequestMapping("/flags")
public class FlagPickerController {

	@Autowired
	private FlagRepository fr;

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@GetMapping
	public List<Country> getAllFlags(@RequestParam String name) {
		logger.info("List flag(s) for {}", name);
		List<Country> list = fr.findByContinentOrCountry(name, name);
		logger.info("Response {}", list);
		return list;
	}
}
