package com.coffeeadvisor.coffeeadvisorback.app.coffee.infrastructure.mapper

import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.Coffee
import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeDto
import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeMapper
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginMapper
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodMapper
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyMapper
import org.springframework.stereotype.Controller

@Controller
class CoffeeMapperImpl(
        private val originMapper: OriginMapper,
        private val varietyMapper: VarietyMapper,
        private val processMethodMapper: ProcessMethodMapper
) : CoffeeMapper {
    override fun dtoToEntity(dto: CoffeeDto) =
            Coffee(dto.uuid,
                    dto.name,
                    dto.growHeightMin,
                    dto.growHeightMax,
                    dto.description,
                    originMapper.dtoToEntity(dto.origin),
                    varietyMapper.dtoToEntity(dto.variety),
                    processMethodMapper.dtoToEntity(dto.processMethod))

    override fun entityToDto(entity: Coffee) =
            CoffeeDto(entity.uuid,
                    entity.name,
                    entity.growHeightMin,
                    entity.growHeightMax,
                    entity.description,
                    originMapper.entityToDto(entity.origin),
                    varietyMapper.entityToDto(entity.variety),
                    processMethodMapper.entityToDto(entity.processMethod))
}