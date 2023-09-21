package de.mbti.carconfigurator.repository

import de.mbti.carconfigurator.db.model.CarConfigurationEntity
import org.springframework.data.repository.CrudRepository

interface CarConfigurationRepository : CrudRepository<CarConfigurationEntity, Int>