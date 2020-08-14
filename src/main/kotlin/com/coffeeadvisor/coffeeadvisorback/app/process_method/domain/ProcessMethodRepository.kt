package com.coffeeadvisor.coffeeadvisorback.app.process_method.domain

import java.rmi.server.UID
import java.util.*

interface ProcessMethodRepository {
    fun getAll(): Iterable<ProcessMethod>
    fun findByUID(uid: UID): Optional<ProcessMethod>
    fun findByCriteria(criteria: ProcessMethod): Iterable<ProcessMethod>
}