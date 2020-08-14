package com.coffeeadvisor.coffeeadvisorback.app.variety.domain

import java.util.*

interface VarietyRepository {
    fun getAll(): Iterable<Variety>
    fun findByUUID(uuid: UUID): Optional<Variety>
}