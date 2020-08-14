package com.coffeeadvisor.coffeeadvisorback.origin.domain

import com.sun.istack.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class Origin(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "origin_seq")
        @SequenceGenerator(name = "origin_seq", sequenceName = "ORIGIN_SEQ", allocationSize = 100)
        val id: Long,
        @NotNull
        val uid: UUID,
        val name: String
)
