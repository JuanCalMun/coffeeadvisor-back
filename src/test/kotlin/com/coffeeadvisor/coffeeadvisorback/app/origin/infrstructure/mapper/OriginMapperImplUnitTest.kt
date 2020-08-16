package com.coffeeadvisor.coffeeadvisorback.app.origin.infrstructure.mapper

import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.Origin
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

internal class OriginMapperImplUnitTest {
    private val DEFAULT_ENTITY_ID: Long = 0L
    private val originMapperImpl = OriginMapperImpl()

    private val UUID_ORIGIN_A = UUID.randomUUID()
    private val ENTITY_ORIGIN_A = Origin(UUID_ORIGIN_A, "Origin A", 1234L)
    private val ENTITY_ORIGIN_A_WITH_DEFAULT_ID =
            Origin(UUID_ORIGIN_A, "Origin A", DEFAULT_ENTITY_ID)
    private val DTO_ORIGIN_A = OriginDto(UUID_ORIGIN_A, "Origin A")

    private val UUID_ORIGIN_B = UUID.randomUUID()
    private val ENTITY_ORIGIN_B_WITH_DEFAULT_ID = Origin(UUID_ORIGIN_B, "Origin B")
    private val DTO_ORIGIN_B = OriginDto(UUID_ORIGIN_B, "Origin B")


    @Test
    fun whenMapEntity_ThenReturnDto() {
        val dtoResult = originMapperImpl.entityToDto(ENTITY_ORIGIN_A)
        Assertions.assertEquals(DTO_ORIGIN_A, dtoResult)
    }

    @Test
    fun whenMapEntityWithDefaultId_ThenReturnDto() {
        val dtoResult = originMapperImpl.entityToDto(ENTITY_ORIGIN_B_WITH_DEFAULT_ID)
        Assertions.assertEquals(DTO_ORIGIN_B, dtoResult)
    }

    @Test
    fun whenMapDto_ThenReturnEntityWithDefaultId() {
        val originADtoResult = originMapperImpl.dtoToEntity(DTO_ORIGIN_A)
        val originBDtoResult = originMapperImpl.dtoToEntity(DTO_ORIGIN_B)
        Assertions.assertEquals(ENTITY_ORIGIN_A_WITH_DEFAULT_ID, originADtoResult)
        Assertions.assertEquals(ENTITY_ORIGIN_B_WITH_DEFAULT_ID, originBDtoResult)
        Assertions.assertEquals(DEFAULT_ENTITY_ID, originADtoResult.id)
        Assertions.assertEquals(DEFAULT_ENTITY_ID, originBDtoResult.id)
    }

}