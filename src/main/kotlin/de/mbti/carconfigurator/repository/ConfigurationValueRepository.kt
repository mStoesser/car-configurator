package de.mbti.carconfigurator.repository

import de.mbti.carconfigurator.db.model.ConfigurationValueEntity
import org.springframework.data.repository.CrudRepository

interface ConfigurationValueRepository : CrudRepository<ConfigurationValueEntity, Int> {
    fun findByConfigurationId(id: Int): List<ConfigurationValueEntity>
}