package com.coffeeadvisor.coffeeadvisorback.app.variety.infrastructure.rest

import com.coffeeadvisor.coffeeadvisorback.app.variety.application.VarietyFetcher
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/variety")
class VarietyRestController(private val varietyFetcher: VarietyFetcher) {
    @GetMapping
    fun getAllVarieties() = ResponseEntity(varietyFetcher.getAll(), HttpStatus.OK)
}