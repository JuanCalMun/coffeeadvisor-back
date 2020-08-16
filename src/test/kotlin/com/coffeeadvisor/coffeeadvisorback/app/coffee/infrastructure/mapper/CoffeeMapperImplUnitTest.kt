package com.coffeeadvisor.coffeeadvisorback.app.coffee.infrastructure.mapper

import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.Coffee
import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeDto
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.Origin
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginDto
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginMapper
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethod
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodDto
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodMapper
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.Variety
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyDto
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyMapper
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
internal class CoffeeMapperImplUnitTest {

    @MockK
    private lateinit var originMapper: OriginMapper

    @MockK
    private lateinit var processMethodMapper: ProcessMethodMapper

    @MockK
    private lateinit var varietyMapper: VarietyMapper

    @InjectMockKs
    private lateinit var coffeeMapperImpl: CoffeeMapperImpl


    private val UUID_ORIGIN = UUID.randomUUID()
    private val ENTITY_ORIGIN = Origin(UUID_ORIGIN, "Origin", 1234L)
    private val DTO_ORIGIN = OriginDto(UUID_ORIGIN, "Origin")

    private val UUID_PROCESS_METHOD = UUID.randomUUID()
    private val ENTITY_PROCESS_METHOD = ProcessMethod(UUID_PROCESS_METHOD, "ProcessMethod", 1234L)
    private val DTO_PROCESS_METHOD = ProcessMethodDto(UUID_PROCESS_METHOD, "ProcessMethod")

    private val UUID_VARIETY = UUID.randomUUID()
    private val ENTITY_VARIETY = Variety(UUID_VARIETY, "Variety", 1234L)
    private val DTO_VARIETY = VarietyDto(UUID_VARIETY, "Variety")

    private val UUID_COFFEE = UUID.randomUUID()
    private val ENTITY_COFFEE = Coffee(
            UUID_COFFEE,
            "Coffe name",
            1000,
            1200,
            "Coffee description",
            ENTITY_ORIGIN,
            ENTITY_VARIETY,
            ENTITY_PROCESS_METHOD)
    private val DTO_COFFEE = CoffeeDto(
            UUID_COFFEE,
            "Coffe name",
            1000,
            1200,
            "Coffee description",
            DTO_ORIGIN,
            DTO_VARIETY,
            DTO_PROCESS_METHOD)


    @Test
    fun whenMapEntity_ThenReturnDto() {
        every { originMapper.entityToDto(any()) } returns DTO_ORIGIN
        every { processMethodMapper.entityToDto(any()) } returns DTO_PROCESS_METHOD
        every { varietyMapper.entityToDto(any()) } returns DTO_VARIETY

        val dtoResult = coffeeMapperImpl.entityToDto(ENTITY_COFFEE)
        Assertions.assertEquals(DTO_COFFEE, dtoResult)
    }

    @Test
    fun whenMapDto_ThenReturnEntityWithDefaultId() {
        every { originMapper.dtoToEntity(any()) } returns ENTITY_ORIGIN
        every { processMethodMapper.dtoToEntity(any()) } returns ENTITY_PROCESS_METHOD
        every { varietyMapper.dtoToEntity(any()) } returns ENTITY_VARIETY

        val coffeeADtoResult = coffeeMapperImpl.dtoToEntity(DTO_COFFEE)
        Assertions.assertEquals(ENTITY_COFFEE, coffeeADtoResult)
    }

}