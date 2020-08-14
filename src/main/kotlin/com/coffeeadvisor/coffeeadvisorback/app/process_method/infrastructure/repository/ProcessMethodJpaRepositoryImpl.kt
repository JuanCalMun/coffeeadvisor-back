package com.coffeeadvisor.coffeeadvisorback.app.process_method.infrastructure.repository

import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethod
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodRepository
import java.util.*

class ProcessMethodJpaRepositoryImpl(private val processMethodJpaRepository: ProcessMethodJpaRepository)
    : ProcessMethodRepository {
    override fun getAll(): Iterable<ProcessMethod> = processMethodJpaRepository.findAll()

    override fun findByUUID(uuid: UUID) = processMethodJpaRepository.findByUuid(uuid)

}