package com.hcl.flagpicker;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.flagpicker.controller.FlagPickerController;
import com.hcl.flagpicker.model.Country;
import com.hcl.flagpicker.repository.FlagRepository;

@WebMvcTest(FlagPickerController.class)
public class WebTestClientTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private FlagRepository fr;

	@Test
	void flagpickerGETTest1() throws Exception {
		given(fr.findByContinentOrCountry(null, null)).willReturn(null);
		mvc.perform(get("/flags?name=Ethiopia")).andExpect(status().isOk());
	}

	@Test
	void flagpickerGETTest2() throws Exception {
		mvc.perform(get("/flags")).andExpect(status().is4xxClientError());
	}

	@Test
	void flagpickerGETTest3() throws Exception {
		Country ct = new Country("Africa", "Ethiopia");
		List<Country> list = new ArrayList<>();
		list.add(ct);
		given(fr.findByContinentOrCountry(anyString(), anyString())).willReturn(list);
		mvc.perform(get("/flags?name=Ethiopia"))
				.andExpect(content().json("[ {\n" + "        \"country\": \"Ethiopia\"\n" + "    }]"));
	}

}
