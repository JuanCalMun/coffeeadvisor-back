package com.coffeeadvisor.coffeeadvisorback.app.variety.infrastructure.mapper

import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.Variety
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyDto
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyMapper
import org.springframework.stereotype.Controller

@Controller
class VarietyMapperImpl : VarietyMapper {
    override fun dtoToEntity(dto: VarietyDto) = Variety(dto.uuid, dto.name)
    override fun entityToDto(entity: Variety) = VarietyDto(entity.uuid, entity.name)
}