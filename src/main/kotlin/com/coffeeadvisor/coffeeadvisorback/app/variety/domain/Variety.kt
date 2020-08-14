package com.coffeeadvisor.coffeeadvisorback.app.variety.domain

import com.sun.istack.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class Variety(
        @NotNull
        var uuid: UUID,
        var name: String,
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "variety_seq")
        @SequenceGenerator(name = "variety_seq", sequenceName = "VARIETY_SEQ", allocationSize = 100)
        var id: Long = 0L
)
