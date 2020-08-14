package com.coffeeadvisor.coffeeadvisorback.app.coffee.domain

import java.util.*

interface CoffeeRepository {
    fun getAll(): Iterable<Coffee>
    fun findByUUID(uuid: UUID): Optional<Coffee>
    fun findByCriteria(criteria: Coffee): Iterable<Coffee>
}