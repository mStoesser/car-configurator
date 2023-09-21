package de.mbti.carconfigurator.db.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "car_configuration")
class CarConfigurationEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int?,
    var productId: Int,
    var name: String,
    @OneToMany(mappedBy = "configuration")
    var values: List<ConfigurationValueEntity>,
    var price: Long,
)
