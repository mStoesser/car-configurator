package de.mbti.carconfigurator.service

import de.mbti.carconfigurator.api.model.ConfigurationValue
import de.mbti.carconfigurator.api.model.CarProduct
import de.mbti.carconfigurator.api.model.CarProductAxis
import de.mbti.carconfigurator.db.model.CarProductAxisEntity
import de.mbti.carconfigurator.db.model.CarProductEntity
import de.mbti.carconfigurator.repository.CarProductAxisRepository
import de.mbti.carconfigurator.repository.CarProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CarProductService(
    val carProductRepository: CarProductRepository,
    val carProductAxisRepository: CarProductAxisRepository,
) {

    fun get(id: Int): CarProduct? {
        val defaultConfiguration = carProductAxisRepository.findByProductId(id)
        return carProductRepository.findByIdOrNull(id)?.let{
            map(it, defaultConfiguration)
        }
    }

    fun list(): List<CarProduct> {
        return carProductRepository.findAll().map {
            val defaultConfiguration = carProductAxisRepository.findByProductId(it.id)
            map(it, defaultConfiguration)
        }.toList()
    }

    fun map(entity: CarProductEntity, configurations: List<CarProductAxisEntity>) = CarProduct(
        id = entity.id,
        type = entity.carType,
        klass = entity.carClass,
        defaultConfiguration = configurations.map { ConfigurationValue(it.name, it.defaultValue) },
    )

    fun listAxis(id: Int): List<CarProductAxis> {
        return carProductAxisRepository.findByProductId(id).map {
            CarProductAxis(
                key = it.name,
                values = it.productAxisValues.map { it.axisValue },
                defaultValue = it.defaultValue,
                multipleValues = it.multiple,
            )
        }
    }
}