package com.coffeeadvisor.coffeeadvisorback.coffee.domain

import com.coffeeadvisor.coffeeadvisorback.variety.domain.Variety
import com.sun.istack.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class Coffee(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universe_seq")
        @SequenceGenerator(name = "universe_seq", sequenceName = "UNIVERSE_SEQ", allocationSize = 100)
        var id: Long,
        @NotNull
        var uid: UUID,
        var name: String,
        var growHeight: Int,
        var description: String,
        @ManyToOne(optional = true, fetch = FetchType.EAGER)
        var variety: Variety
//        TODO realation to to origin and processMethod
)