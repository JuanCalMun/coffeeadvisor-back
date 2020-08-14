package com.coffeeadvisor.coffeeadvisorback.app.variety.domain

import java.rmi.server.UID
import java.util.*

interface VarietyRepository {
    fun getAll(): Iterable<Variety>
    fun findByUID(uid: UID): Optional<Variety>
    fun findByCriteria(criteria: Variety): Iterable<Variety>
}