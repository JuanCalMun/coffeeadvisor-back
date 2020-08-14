package com.coffeeadvisor.coffeeadvisorback.app.process_method.domain

import java.util.*

interface ProcessMethodRepository {
    fun getAll(): Iterable<ProcessMethod>
    fun findByUUID(uuid: UUID): Optional<ProcessMethod>
}