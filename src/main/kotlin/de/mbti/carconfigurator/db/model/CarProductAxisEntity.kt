package de.mbti.carconfigurator.db.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "car_product_axis")
class CarProductAxisEntity(
    @Id
    var id: Long,
    var productId: Long,
    var name: String,
    var defaultValue: String,
    var multiple: Boolean,
    @OneToMany(mappedBy = "productAxis")
    var productAxisValues: List<CarProductAxisValueEntity>
)