package com.coffeeadvisor.coffeeadvisorback.app.coffee.domain

import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.Origin
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethod
import com.coffeeadvisor.coffeeadvisorback.app.shared.domain.data.BaseDto
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.Variety
import java.util.*

data class CoffeeDto(
        val uuid: UUID,
        val name: String,
        val growHeightMin: Int,
        val growHeightMax: Int,
        val description: String,
        val origin: Origin,
        val variety: Variety,
        val processMethod: ProcessMethod
) : BaseDto()