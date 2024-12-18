package net.talaatharb.healthcatalog.facade;

import java.util.List;

import net.talaatharb.healthcatalog.dto.HealthCatalogVersionDto;

public interface HealthCatalogFacade {

	List<HealthCatalogVersionDto> getAllAvailableVersions();

}
