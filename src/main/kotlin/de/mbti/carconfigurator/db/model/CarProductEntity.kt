package de.mbti.carconfigurator.db.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "car_product")
class CarProductEntity(
    @Id var id: Int,
    var carClass: String,
    var carType: String,
    var price: Long,
)
