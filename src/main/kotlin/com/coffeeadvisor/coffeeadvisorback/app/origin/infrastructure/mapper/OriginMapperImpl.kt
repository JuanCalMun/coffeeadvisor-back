package com.coffeeadvisor.coffeeadvisorback.app.origin.infrastructure.mapper

import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.Origin
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginDto
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginMapper
import org.springframework.stereotype.Controller

@Controller
class OriginMapperImpl : OriginMapper {
    override fun dtoToEntity(dto: OriginDto) = Origin(dto.uuid, dto.name)
    override fun entityToDto(entity: Origin) = OriginDto(entity.uuid, entity.name)
}