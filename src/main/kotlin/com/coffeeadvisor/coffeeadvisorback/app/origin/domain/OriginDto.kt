package com.coffeeadvisor.coffeeadvisorback.app.origin.domain

import com.coffeeadvisor.coffeeadvisorback.app.shared.domain.data.BaseDto
import java.util.*

data class OriginDto(val uuid: UUID, val name: String) : BaseDto()