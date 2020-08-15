package com.coffeeadvisor.coffeeadvisorback.app.process_method.infrastructure.mapper

import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethod
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodDto
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodMapper
import org.springframework.stereotype.Controller

@Controller
class ProcessMethodMapperImpl : ProcessMethodMapper {
    override fun dtoToEntity(dto: ProcessMethodDto) = ProcessMethod(dto.uuid, dto.name)
    override fun entityToDto(entity: ProcessMethod) = ProcessMethodDto(entity.uuid, entity.name)
}