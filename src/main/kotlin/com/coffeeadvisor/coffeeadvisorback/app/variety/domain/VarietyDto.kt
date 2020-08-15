package com.coffeeadvisor.coffeeadvisorback.app.variety.domain

import com.coffeeadvisor.coffeeadvisorback.app.shared.domain.data.BaseDto
import java.util.*

data class VarietyDto(val uuid: UUID, val name: String) : BaseDto()