package de.mbti.carconfigurator.resource

import de.mbti.carconfigurator.api.model.Configuration
import de.mbti.carconfigurator.service.CarConfigurationService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/configuration", produces = [MediaType.APPLICATION_JSON_VALUE])
class CarConfigurationResource(
    val carConfigurationService: CarConfigurationService,
) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: Int) = carConfigurationService.get(id)

    @GetMapping("/")
    fun list() = carConfigurationService.list()

    @PostMapping("/")
    fun create(@RequestBody configuration: Configuration) = carConfigurationService.create(configuration)

    @PostMapping("/validate")
    fun validate(@RequestBody configuration: Configuration) = carConfigurationService.validate(configuration)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody configuration: Configuration) = carConfigurationService.update(id, configuration)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = carConfigurationService.delete(id)
}