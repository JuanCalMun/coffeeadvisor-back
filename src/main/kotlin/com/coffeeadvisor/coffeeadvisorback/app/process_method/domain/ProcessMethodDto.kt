package com.coffeeadvisor.coffeeadvisorback.app.process_method.domain

import com.coffeeadvisor.coffeeadvisorback.app.shared.domain.data.BaseDto
import java.util.*

data class ProcessMethodDto(val uuid: UUID, val name: String) : BaseDto()