package net.talaatharb.healthcatalog.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class HealthCatalogVersionEntity extends GeneratedIdBaseEntity {

	private Instant issueDate;
}
