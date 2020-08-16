package com.coffeeadvisor.coffeeadvisorback.app.variety.infrastructure.mapper

import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.Variety
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

internal class VarietyMapperImplUnitTest {
    private val varietyMapperImpl = VarietyMapperImpl()

    private val UUID_VARIETY_A = UUID.randomUUID()
    private val ENTITY_VARIETY_A = Variety(UUID_VARIETY_A, "Variety A", 1234L)
    private val ENTITY_VARIETY_A_WITH_DEFAULT_ID = Variety(UUID_VARIETY_A, "Variety A", 0L)
    private val DTO_VARIETY_A = VarietyDto(UUID_VARIETY_A, "Variety A")

    private val UUID_VARIETY_B = UUID.randomUUID()
    private val ENTITY_VARIETY_B_WITH_DEFAULT_ID = Variety(UUID_VARIETY_B, "Variety B")
    private val DTO_VARIETY_B = VarietyDto(UUID_VARIETY_B, "Variety B")

    @Test
    fun whenMapEntity_ThenReturnDto() {
        val dtoResult = varietyMapperImpl.entityToDto(ENTITY_VARIETY_A)
        Assertions.assertEquals(DTO_VARIETY_A, dtoResult)
    }

    @Test
    fun whenMapEntityWithDefaultId_ThenReturnDto() {
        val dtoResult = varietyMapperImpl.entityToDto(ENTITY_VARIETY_B_WITH_DEFAULT_ID)
        Assertions.assertEquals(DTO_VARIETY_B, dtoResult)
    }

    @Test
    fun whenMapDto_ThenReturnEntityWithDefaultId() {
        val varietyADtoResult = varietyMapperImpl.dtoToEntity(DTO_VARIETY_A)
        val varietyBDtoResult = varietyMapperImpl.dtoToEntity(DTO_VARIETY_B)
        Assertions.assertEquals(ENTITY_VARIETY_A_WITH_DEFAULT_ID, varietyADtoResult)
        Assertions.assertEquals(ENTITY_VARIETY_B_WITH_DEFAULT_ID, varietyBDtoResult)
    }
}