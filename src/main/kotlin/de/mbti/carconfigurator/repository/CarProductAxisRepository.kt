package de.mbti.carconfigurator.repository

import de.mbti.carconfigurator.db.model.CarProductAxisEntity
import org.springframework.data.repository.CrudRepository

interface CarProductAxisRepository : CrudRepository<CarProductAxisEntity, Int> {

    fun findByProductId(productId: Int): List<CarProductAxisEntity>
}