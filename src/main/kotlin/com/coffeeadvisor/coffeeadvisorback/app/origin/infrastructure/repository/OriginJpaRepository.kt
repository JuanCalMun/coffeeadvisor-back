package com.coffeeadvisor.coffeeadvisorback.app.origin.infrastructure.repository

import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.Origin
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface OriginJpaRepository : JpaRepository<Origin, Long> {
    fun findByUuid(uuid: UUID): Optional<Origin>
}