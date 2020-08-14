package com.coffeeadvisor.coffeeadvisorback.coffee.domain

import com.coffeeadvisor.coffeeadvisorback.origin.domain.Origin
import com.coffeeadvisor.coffeeadvisorback.process_method.domain.ProcessMethod
import com.coffeeadvisor.coffeeadvisorback.variety.domain.Variety
import com.sun.istack.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class Coffee(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universe_seq")
        @SequenceGenerator(name = "universe_seq", sequenceName = "UNIVERSE_SEQ", allocationSize = 100)
        val id: Long,
        @NotNull
        val uid: UUID,
        val name: String,
        val growHeight: Int,
        val description: String,
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        val origin: Origin,
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        val variety: Variety,
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        val processMethod: ProcessMethod
)