package com.coffeeadvisor.coffeeadvisorback.app.coffee.application

import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeMapper
import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CoffeeFetcher(
        private val coffeeMapper: CoffeeMapper,
        private val coffeeRepository: CoffeeRepository
) {
    fun getAll() = coffeeMapper.entityToDtoList(coffeeRepository.getAll())
    fun getOne(uuid: UUID) =
            coffeeMapper.entityToDto(coffeeRepository.findByUUID(uuid).orElseThrow())
}