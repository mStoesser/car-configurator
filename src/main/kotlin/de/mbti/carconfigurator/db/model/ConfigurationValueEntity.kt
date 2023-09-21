package de.mbti.carconfigurator.db.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "car_configuration_value")
class ConfigurationValueEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    @ManyToOne
    @JoinColumn(name="product_configuration_id", referencedColumnName = "id")
    var configuration: CarConfigurationEntity,
    var axisKey: String,
    var axisValue: String,
)
