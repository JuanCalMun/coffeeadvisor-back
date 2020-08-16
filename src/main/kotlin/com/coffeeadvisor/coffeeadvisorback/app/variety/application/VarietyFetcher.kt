package com.coffeeadvisor.coffeeadvisorback.app.variety.application

import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyMapper
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyRepository
import org.springframework.stereotype.Service

@Service
class VarietyFetcher(
        private val varietyRepository: VarietyRepository,
        private val varietyMapper: VarietyMapper
) {
    fun getAll() = varietyMapper.entityToDtoList(varietyRepository.getAll())
}