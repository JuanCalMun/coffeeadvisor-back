package com.coffeeadvisor.coffeeadvisorback.app.process_method.infrastructure.rest

import com.coffeeadvisor.coffeeadvisorback.app.process_method.application.ProcessMethodFetcher
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/process-method")
class ProcessMethodRestController(private val processMethodFetcher: ProcessMethodFetcher) {
    @GetMapping
    fun getAllProcessMethods() = ResponseEntity(processMethodFetcher.getAll(), HttpStatus.OK)
}
