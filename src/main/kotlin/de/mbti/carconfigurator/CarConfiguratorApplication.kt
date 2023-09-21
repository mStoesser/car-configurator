package de.mbti.carconfigurator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarConfiguratorApplication

fun main(args: Array<String>) {
	runApplication<CarConfiguratorApplication>(*args)
}
