package net.talaatharb.healthcatalog.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.talaatharb.healthcatalog.dto.HealthCatalogVersionDto;
import net.talaatharb.healthcatalog.mapper.HealthCatalogVersionMapper;
import net.talaatharb.healthcatalog.service.HealthCatalogVersionService;

@RequiredArgsConstructor
@Service
@Slf4j
public class HealthCatalogFacadeImpl implements HealthCatalogFacade{

	private final HealthCatalogVersionMapper healthCatalogVersionMapper;
	private final HealthCatalogVersionService healthCatalogVersionService;

	@Override
	public List<HealthCatalogVersionDto> getAllAvailableVersions(){
		log.debug("Getting list of all available versions");
		var versionList = healthCatalogVersionService.getAllAvailableVersions();
		log.debug("Found {} versions", versionList.size());
		log.debug("Versions: {}", versionList.toString());
		
		return healthCatalogVersionMapper.fromEntityToDto(versionList);
	}
}
