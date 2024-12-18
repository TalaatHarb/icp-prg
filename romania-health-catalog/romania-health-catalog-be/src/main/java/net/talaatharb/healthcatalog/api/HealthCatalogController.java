package net.talaatharb.healthcatalog.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.talaatharb.healthcatalog.dto.HealthCatalogVersionDto;
import net.talaatharb.healthcatalog.facade.HealthCatalogFacade;

@RequiredArgsConstructor
@RestController
@Slf4j
public class HealthCatalogController implements HealthCatalogApi{

	private final HealthCatalogFacade healthCatalogFacade;
	
	@Override
	public List<HealthCatalogVersionDto> getAllAvailableVersions(){
		return healthCatalogFacade.getAllAvailableVersions();
	}
}
