package com.coffeeadvisor.coffeeadvisorback.app.process_method.domain

import com.coffeeadvisor.coffeeadvisorback.app.shared.domain.data.BaseEntity
import com.sun.istack.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class ProcessMethod(
        @NotNull
        val uuid: UUID,
        val name: String,
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "process_method_seq")
        @SequenceGenerator(name = "process_method_seq", sequenceName = "PROCESS_METHOD_SEQ", allocationSize = 100)
        val id: Long = 0L
) : BaseEntity()