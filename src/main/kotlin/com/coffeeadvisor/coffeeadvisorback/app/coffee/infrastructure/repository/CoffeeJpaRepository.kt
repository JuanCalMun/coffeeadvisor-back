package com.coffeeadvisor.coffeeadvisorback.app.coffee.infrastructure.repository

import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.Coffee
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CoffeeJpaRepository : JpaRepository<Coffee, Long> {
    fun findByUuid(uuid: UUID): Optional<Coffee>
}