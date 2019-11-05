package com.hcl.flagpicker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@WebMvcTest
public class WebTestClientTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void flagpickerGETTest1() throws Exception {

		mvc.perform(get("/flags?name=Ethiopia")).andExpect(status().isOk());
	}

	@Test
	void flagpickerGETTest2(@Autowired WebTestClient webClient) {
		webClient.get().uri("/flags?name=Ethiopia").exchange().expectStatus().isOk();
	}
}
