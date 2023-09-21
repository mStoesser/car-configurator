package de.mbti.carconfigurator.api.model

data class CarProduct(
    val id: Int,
    val type: String,
    val klass: String,
    val defaultConfiguration: List<ConfigurationValue>,
)
