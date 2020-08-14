package com.coffeeadvisor.coffeeadvisorback.app.origin.domain

import com.sun.istack.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class Origin(
        @NotNull
        val uuid: UUID,
        val name: String,
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "origin_seq")
        @SequenceGenerator(name = "origin_seq", sequenceName = "ORIGIN_SEQ", allocationSize = 100)
        val id: Long = 0L
)
