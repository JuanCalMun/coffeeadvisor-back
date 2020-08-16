package com.coffeeadvisor.coffeeadvisorback.app.origin.infrastructure.rest

import com.coffeeadvisor.coffeeadvisorback.app.origin.application.OriginFetcher
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/origin")
class OriginRestController(private val originFetcher: OriginFetcher) {
    @GetMapping
    fun getAllOrigins() = ResponseEntity(originFetcher.getAll(), HttpStatus.OK)
}