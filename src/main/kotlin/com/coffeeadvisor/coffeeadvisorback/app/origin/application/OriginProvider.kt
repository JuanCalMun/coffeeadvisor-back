package com.coffeeadvisor.coffeeadvisorback.app.origin.application

import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginMapper
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginRepository
import org.springframework.stereotype.Service

@Service
class OriginProvider(
        private val originRepository: OriginRepository,
        private val originMapper: OriginMapper
) {
    fun getAll() = originMapper.entityToDtoList(originRepository.getAll())
}