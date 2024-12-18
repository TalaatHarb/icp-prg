package net.talaatharb.healthcatalog.service;

import java.util.List;

import net.talaatharb.healthcatalog.model.HealthCatalogVersionEntity;

public interface HealthCatalogVersionService {

	List<HealthCatalogVersionEntity> getAllAvailableVersions();

}
