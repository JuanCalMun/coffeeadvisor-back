package com.coffeeadvisor.coffeeadvisorback.app.origin.infrstructure.repository

import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.Origin
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginRepository
import java.util.*

class OriginJpaRepositoryImpl(private val originJpaRepository: OriginJpaRepository)
    : OriginRepository {
    override fun getAll(): Iterable<Origin> = originJpaRepository.findAll()

    override fun findByUUID(uuid: UUID) = originJpaRepository.findByUuid(uuid)

}