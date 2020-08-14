package com.coffeeadvisor.coffeeadvisorback.app.process_method.domain

import com.sun.istack.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class ProcessMethod(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "process_method_seq")
        @SequenceGenerator(name = "process_method_seq", sequenceName = "PROCESS_METHOD_SEQ", allocationSize = 100)
        val id: Long,
        @NotNull
        val uuid: UUID,
        val name: String
)
