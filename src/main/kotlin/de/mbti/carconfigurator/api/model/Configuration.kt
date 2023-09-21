package de.mbti.carconfigurator.api.model

data class Configuration(
    val id: Int?,
    val productId: Int,
    val type: String?,
    val klass: String?,
    val name: String,
    val configurationValues: List<ConfigurationValue>,
    var price: Double?,
)
