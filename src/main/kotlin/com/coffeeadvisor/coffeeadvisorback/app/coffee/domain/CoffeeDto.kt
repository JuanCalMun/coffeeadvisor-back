package com.coffeeadvisor.coffeeadvisorback.app.coffee.domain

import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginDto
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodDto
import com.coffeeadvisor.coffeeadvisorback.app.shared.domain.data.BaseDto
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyDto
import java.util.*

data class CoffeeDto(
        val uuid: UUID,
        val name: String,
        val growHeightMin: Int,
        val growHeightMax: Int,
        val description: String,
        val origin: OriginDto,
        val variety: VarietyDto,
        val processMethod: ProcessMethodDto
) : BaseDto()