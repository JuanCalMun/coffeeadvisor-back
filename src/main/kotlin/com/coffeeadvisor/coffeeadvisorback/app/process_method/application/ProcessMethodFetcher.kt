package com.coffeeadvisor.coffeeadvisorback.app.process_method.application

import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodMapper
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping

@Service
class ProcessMethodFetcher(
        private val processMethodMapper: ProcessMethodMapper,
        private val processMethodRepository: ProcessMethodRepository
) {
    @GetMapping
    fun getAll() = processMethodMapper.entityToDtoList(processMethodRepository.getAll())
}