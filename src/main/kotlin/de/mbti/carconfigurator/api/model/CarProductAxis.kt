package de.mbti.carconfigurator.api.model

data class CarProductAxis(
    val key: String,
    val values: List<String>,
    val defaultValue: String,
    val multipleValues: Boolean,
)
