package de.mbti.carconfigurator.api.model

data class Configuration(
    val id: Int?,
    val productId: Int,
    val name: String,
    val configurationValues: List<ConfigurationValue>,
    var price: Double?,
)
