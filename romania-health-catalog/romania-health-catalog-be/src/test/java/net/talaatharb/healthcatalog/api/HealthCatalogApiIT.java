package net.talaatharb.healthcatalog.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import net.talaatharb.healthcatalog.constants.ApiConstants;

class HealthCatalogApiIT extends AbstractAPIIT{

	@Test
	void testCallVersionsAPI() throws Exception {
		final ResultActions result = mvc.perform(get(ApiConstants.VERSIONS_API_V1).accept(MediaType.APPLICATION_JSON));

		result.andExpect(MockMvcResultMatchers.status().is(200));
	}

}
