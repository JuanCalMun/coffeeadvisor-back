package com.coffeeadvisor.coffeeadvisorback.app.coffee.infrastructure.repository

import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.Coffee
import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CoffeeJpaRepositoryImpl(private val coffeeJpaRepository: CoffeeJpaRepository)
    : CoffeeRepository {
    override fun getAll(): Iterable<Coffee> = coffeeJpaRepository.findAll()

    override fun findByUUID(uuid: UUID) = coffeeJpaRepository.findByUuid(uuid)

    override fun findByCriteria(criteria: Coffee): Iterable<Coffee> {
        TODO("Not yet implemented")
    }

}