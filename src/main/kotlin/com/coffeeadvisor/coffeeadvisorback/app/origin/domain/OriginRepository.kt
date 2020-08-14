package com.coffeeadvisor.coffeeadvisorback.app.origin.domain

import java.util.*

interface OriginRepository {
    fun getAll(): Iterable<Origin>
    fun findByUUID(uuid: UUID): Optional<Origin>
}