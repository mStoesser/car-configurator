package de.mbti.carconfigurator.repository

import de.mbti.carconfigurator.db.model.CarProductEntity
import org.springframework.data.repository.CrudRepository

interface CarProductRepository : CrudRepository<CarProductEntity, Int> {

}