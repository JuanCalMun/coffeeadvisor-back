package com.coffeeadvisor.coffeeadvisorback.app.process_method.infrastructure.repository

import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethod
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProcessMethodJpaRepository : JpaRepository<ProcessMethod, Long> {
    fun findByUuid(uuid: UUID): Optional<ProcessMethod>
}