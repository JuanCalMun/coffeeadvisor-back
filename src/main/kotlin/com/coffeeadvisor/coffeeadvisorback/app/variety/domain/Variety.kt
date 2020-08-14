package com.coffeeadvisor.coffeeadvisorback.app.variety.domain

import com.sun.istack.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class Variety(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "variety_seq")
        @SequenceGenerator(name = "variety_seq", sequenceName = "VARIETY_SEQ", allocationSize = 100)
        val id: Long,
        @NotNull
        val uuid: UUID,
        val name: String
)
