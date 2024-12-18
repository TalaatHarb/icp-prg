package net.talaatharb.healthcatalog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.talaatharb.healthcatalog.model.HealthCatalogVersionEntity;
import net.talaatharb.healthcatalog.repository.HealthCatalogVersionRepository;

@RequiredArgsConstructor
@Service
public class HealthCatalogVersionServiceImpl implements HealthCatalogVersionService{
	
	private final HealthCatalogVersionRepository healthCatalogVersionRepository;
	
	@Override
	public List<HealthCatalogVersionEntity> getAllAvailableVersions(){
		return healthCatalogVersionRepository.findAll();
	}

}
