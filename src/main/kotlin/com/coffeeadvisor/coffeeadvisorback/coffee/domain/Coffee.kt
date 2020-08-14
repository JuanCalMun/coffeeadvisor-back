package com.coffeeadvisor.coffeeadvisorback.coffee.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Coffee(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        var id: Long,
        var uid: UUID
)