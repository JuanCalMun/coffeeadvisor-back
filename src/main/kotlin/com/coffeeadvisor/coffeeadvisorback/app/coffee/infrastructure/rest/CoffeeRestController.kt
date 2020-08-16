package com.coffeeadvisor.coffeeadvisorback.app.coffee.infrastructure.rest

import com.coffeeadvisor.coffeeadvisorback.app.coffee.application.CoffeeProvider
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/coffee")
class CoffeeRestController(private val coffeeProvider: CoffeeProvider) {
    @GetMapping
    fun getAllCoffees() = ResponseEntity(coffeeProvider.getAll(), HttpStatus.OK)

    @GetMapping("/{coffeeUUID}")
    fun getCoffeeByUuid(@PathVariable coffeeUUID: UUID) =
            ResponseEntity(coffeeProvider.getOne(coffeeUUID), HttpStatus.OK)
}