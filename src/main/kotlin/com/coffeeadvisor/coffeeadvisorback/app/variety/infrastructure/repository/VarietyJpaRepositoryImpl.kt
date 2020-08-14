package com.coffeeadvisor.coffeeadvisorback.app.variety.infrastructure.repository

import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.Variety
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyRepository
import java.util.*

class VarietyJpaRepositoryImpl(private val varietyJpaRepository: VarietyJpaRepository)
    : VarietyRepository {
    override fun getAll(): Iterable<Variety> = varietyJpaRepository.findAll()

    override fun findByUUID(uuid: UUID) = varietyJpaRepository.findByUuid(uuid)
}