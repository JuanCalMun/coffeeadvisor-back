package com.coffeeadvisor.coffeeadvisorback.app.origin.infrastructure.rest

import com.coffeeadvisor.coffeeadvisorback.app.origin.application.OriginProvider
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/origin")
class OriginRestController(private val originProvider: OriginProvider) {
    @GetMapping
    fun getAllOrigins() = ResponseEntity(originProvider.getAll(), HttpStatus.OK)
}