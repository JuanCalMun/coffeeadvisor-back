package com.coffeeadvisor.coffeeadvisorback.app.variety.infrastructure.repository

import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.Variety
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface VarietyJpaRepository : JpaRepository<Variety, Long> {
    fun findByUuid(uuid: UUID): Optional<Variety>
}