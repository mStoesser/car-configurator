package de.mbti.carconfigurator.resource

import de.mbti.carconfigurator.service.CarProductService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("http://localhost:3000") //TODO: use a global cors config
@RequestMapping("/api/product", produces = [MediaType.APPLICATION_JSON_VALUE])
class ProductResource(
    val carProductService: CarProductService,
) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: Int) = carProductService.get(id)

    @GetMapping("/{id}/axis")
    fun listAxis(@PathVariable id: Int) = carProductService.listAxis(id)


    @GetMapping("/")
    fun list() = carProductService.list()

}