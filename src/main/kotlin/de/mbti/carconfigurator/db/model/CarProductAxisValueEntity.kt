package de.mbti.carconfigurator.db.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "car_product_axis_value")
class CarProductAxisValueEntity(
    @Id
    var id: Long,
    var productId: Long,
    @ManyToOne
    @JoinColumn(name = "axis_id", referencedColumnName = "id")
    var productAxis: CarProductAxisEntity,
    var axisValue: String,
    var price: Long,
)