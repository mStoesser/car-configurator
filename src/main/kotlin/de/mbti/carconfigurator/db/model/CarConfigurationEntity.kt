package de.mbti.carconfigurator.db.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "car_configuration")
class CarConfigurationEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int?,
    @ManyToOne
    @JoinColumn(name="productId", referencedColumnName = "id")
    var product: CarProductEntity,
    var name: String,
    @OneToMany(mappedBy = "configuration")
    var values: List<ConfigurationValueEntity>,
    var price: Long,
)
