package com.coffeeadvisor.coffeeadvisorback.app.coffee.infrastructure.rest

import com.coffeeadvisor.coffeeadvisorback.app.coffee.application.services.CoffeeProvider
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/coffee")
class CoffeeRestController(private val coffeeProvider: CoffeeProvider) {
    @GetMapping
    fun getAllCoffees() = coffeeProvider.getAll()
}