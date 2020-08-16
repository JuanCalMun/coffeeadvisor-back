package com.coffeeadvisor.coffeeadvisorback.app.process_method.infrastructure.mapper

import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethod
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

internal class ProcessMethodMapperImplUnitTest {
    private val DEFAULT_ENTITY_ID: Long = 0L
    private val processMethodMapperImpl = ProcessMethodMapperImpl()

    private val UUID_PROCESS_METHOD_A = UUID.randomUUID()
    private val ENTITY_PROCESS_METHOD_A = ProcessMethod(UUID_PROCESS_METHOD_A, "ProcessMethod A", 1234L)
    private val ENTITY_PROCESS_METHOD_A_WITH_DEFAULT_ID =
            ProcessMethod(UUID_PROCESS_METHOD_A, "ProcessMethod A", DEFAULT_ENTITY_ID)
    private val DTO_PROCESS_METHOD_A = ProcessMethodDto(UUID_PROCESS_METHOD_A, "ProcessMethod A")

    private val UUID_PROCESS_METHOD_B = UUID.randomUUID()
    private val ENTITY_PROCESS_METHOD_B_WITH_DEFAULT_ID = ProcessMethod(UUID_PROCESS_METHOD_B, "ProcessMethod B")
    private val DTO_PROCESS_METHOD_B = ProcessMethodDto(UUID_PROCESS_METHOD_B, "ProcessMethod B")


    @Test
    fun whenMapEntity_ThenReturnDto() {
        val dtoResult = processMethodMapperImpl.entityToDto(ENTITY_PROCESS_METHOD_A)
        Assertions.assertEquals(DTO_PROCESS_METHOD_A, dtoResult)
    }

    @Test
    fun whenMapEntityWithDefaultId_ThenReturnDto() {
        val dtoResult = processMethodMapperImpl.entityToDto(ENTITY_PROCESS_METHOD_B_WITH_DEFAULT_ID)
        Assertions.assertEquals(DTO_PROCESS_METHOD_B, dtoResult)
    }

    @Test
    fun whenMapDto_ThenReturnEntityWithDefaultId() {
        val processMethodADtoResult = processMethodMapperImpl.dtoToEntity(DTO_PROCESS_METHOD_A)
        val processMethodBDtoResult = processMethodMapperImpl.dtoToEntity(DTO_PROCESS_METHOD_B)
        Assertions.assertEquals(ENTITY_PROCESS_METHOD_A_WITH_DEFAULT_ID, processMethodADtoResult)
        Assertions.assertEquals(ENTITY_PROCESS_METHOD_B_WITH_DEFAULT_ID, processMethodBDtoResult)
        Assertions.assertEquals(DEFAULT_ENTITY_ID, processMethodADtoResult.id)
        Assertions.assertEquals(DEFAULT_ENTITY_ID, processMethodBDtoResult.id)
    }


}