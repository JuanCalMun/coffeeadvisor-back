package com.coffeeadvisor.coffeeadvisorback.app.coffee.application.services

import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeMapper
import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeRepository
import org.springframework.stereotype.Service

@Service
class CoffeeProvider(private val coffeeMapper: CoffeeMapper,
                     private val coffeeRepository: CoffeeRepository) {
    fun getAll() = coffeeMapper.entityToDtoList(coffeeRepository.getAll())
}