package com.coffeeadvisor.coffeeadvisorback.app.origin.infrstructure.repository

import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.Origin
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class OriginJpaRepositoryImpl(private val originJpaRepository: OriginJpaRepository)
    : OriginRepository {
    override fun getAll(): Iterable<Origin> = originJpaRepository.findAll()

    override fun findByUUID(uuid: UUID) = originJpaRepository.findByUuid(uuid)

}