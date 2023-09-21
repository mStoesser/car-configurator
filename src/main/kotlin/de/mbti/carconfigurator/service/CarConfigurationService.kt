package de.mbti.carconfigurator.service

import de.mbti.carconfigurator.api.model.Configuration
import de.mbti.carconfigurator.api.model.ConfigurationValue
import de.mbti.carconfigurator.db.model.CarConfigurationEntity
import de.mbti.carconfigurator.db.model.CarProductAxisEntity
import de.mbti.carconfigurator.db.model.CarProductAxisValueEntity
import de.mbti.carconfigurator.db.model.CarProductEntity
import de.mbti.carconfigurator.db.model.ConfigurationValueEntity
import de.mbti.carconfigurator.repository.CarConfigurationRepository
import de.mbti.carconfigurator.repository.CarProductAxisRepository
import de.mbti.carconfigurator.repository.CarProductRepository
import de.mbti.carconfigurator.repository.ConfigurationValueRepository
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Transactional
class CarConfigurationService(
    val carProductRepository: CarProductRepository,
    val carProductAxisRepository: CarProductAxisRepository,
    val carConfigurationRepository: CarConfigurationRepository,
    val configurationValueRepository: ConfigurationValueRepository,
    @PersistenceContext val entityManager: EntityManager,
) {

    fun get(id: Int): Configuration? {
        return carConfigurationRepository.findByIdOrNull(id)?.let(::fromEntity)
    }

    fun list(): List<Configuration> {
        return carConfigurationRepository.findAll().map(::fromEntity).toList()
    }

    fun fromEntity(entity: CarConfigurationEntity) = Configuration(
        id = entity.id,
        productId = entity.productId,
        name = entity.name,
        configurationValues = entity.values.map { ConfigurationValue(
            key = it.axisKey,
            value = it.axisValue,
        ) },
        price = entity.price / 100.0,
    )


    fun create(configuration: Configuration): Configuration {
        val product = carProductRepository.findByIdOrNull(configuration.productId)
        val axis = carProductAxisRepository.findByProductId(configuration.productId)
        validateConfigurationWithAxis(configuration, axis)
        return CarConfigurationEntity(
            id = null,
            productId = configuration.productId,
            name = configuration.name,
            values = mutableListOf(),
            price = calculatePrice(configuration.configurationValues, product, axis)
        )
        .also(entityManager::persist)
        .also { configurationEntity ->
            configurationEntity.values = createConfigurationValues(configuration.configurationValues, configurationEntity)
            entityManager.flush()
            entityManager.refresh(configurationEntity)
        }
        .let(::fromEntity)
    }

    fun calculatePrice(configurationValues: List<ConfigurationValue>, carProductEntity: CarProductEntity?, productAxis: List<CarProductAxisEntity>): Long {
        val basePrice = carProductEntity?.price ?: 0
        val additionalPrice = configurationValues.sumOf { configurationValue ->
            productAxis.findByKey(configurationValue.key)
                ?.productAxisValues
                ?.filterValues(configurationValue.value)
                ?.sumOf(CarProductAxisValueEntity::price)
                ?: 0
        }
        return basePrice + additionalPrice
    }

    private fun List<CarProductAxisEntity>.findByKey(key: String) = find { it.name == key }
    private fun List<CarProductAxisValueEntity>.filterValues(value: String) = filter { it.axisValue == value  }


    fun update(id: Int, configuration: Configuration): Configuration? {
        val product = carProductRepository.findByIdOrNull(configuration.productId)
        val axis = carProductAxisRepository.findByProductId(configuration.productId)
        validateConfigurationWithAxis(configuration, axis)
        return carConfigurationRepository.findByIdOrNull(id)?.let { entity ->
            configurationValueRepository.findByConfigurationId(id).forEach(entityManager::remove)
            entity.name = configuration.name
            entity.values = createConfigurationValues(configuration.configurationValues, entity)
            entity.price =  calculatePrice(configuration.configurationValues, product, axis)
            fromEntity(entity)
        }
    }

    fun delete(id: Int) {
        carConfigurationRepository.findByIdOrNull(id)?.let(entityManager::remove)
    }

    fun validate(configuration: Configuration): Configuration {
        val product = carProductRepository.findByIdOrNull(configuration.productId)
        val axis = carProductAxisRepository.findByProductId(configuration.productId)
        validateConfigurationWithAxis(configuration, axis)
        return configuration.apply {
            price = calculatePrice(configuration.configurationValues, product, axis) / 100.0
        }
    }
    fun validateConfigurationWithAxis(configuration: Configuration, productAxis: List<CarProductAxisEntity>) {
         configuration.configurationValues.forEach { configurationValue ->
            val axis = productAxis.find { it.name == configurationValue.key } ?: throw IllegalArgumentException("product axis not found with ${configurationValue.key}")
            axis.productAxisValues.find { it.axisValue == configurationValue.value } ?: throw IllegalArgumentException("product axis value not found with ${configurationValue.key}:${configurationValue.value}")
        }
    }

    private fun createConfigurationValues(configurationValues: List<ConfigurationValue>, configurationEntity: CarConfigurationEntity) =
        configurationValues.map {
            ConfigurationValueEntity(
                id = null,
                configuration = configurationEntity,
                axisKey = it.key,
                axisValue = it.value,
            ).also(entityManager::persist)
        }
}