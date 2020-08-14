package com.coffeeadvisor.coffeeadvisorback.app.coffee.domain

import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.Origin
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethod
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.Variety
import com.sun.istack.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class Coffee(
        @NotNull
        val uuid: UUID,
        val name: String,
        val growHeightMin: Int,
        val growHeightMax: Int,
        val description: String,
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        val origin: Origin,
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        val variety: Variety,
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        val processMethod: ProcessMethod,
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universe_seq")
        @SequenceGenerator(name = "universe_seq", sequenceName = "UNIVERSE_SEQ", allocationSize = 100)
        val id: Long = 0L,
        val isCaffeineFree: Boolean = false
)
