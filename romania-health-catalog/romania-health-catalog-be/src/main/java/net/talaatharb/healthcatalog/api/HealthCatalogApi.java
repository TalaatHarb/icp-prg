package net.talaatharb.healthcatalog.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.talaatharb.healthcatalog.constants.ApiConstants;
import net.talaatharb.healthcatalog.dto.HealthCatalogVersionDto;

@RequestMapping(ApiConstants.API_V1)
@CrossOrigin
public interface HealthCatalogApi {

	@GetMapping(ApiConstants.VERSIONS)
	@ResponseStatus(HttpStatus.OK)
	List<HealthCatalogVersionDto> getAllAvailableVersions();

}
