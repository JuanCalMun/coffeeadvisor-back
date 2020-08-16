package com.coffeeadvisor.coffeeadvisorback.app.coffee.application

import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.Coffee
import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeDto
import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeMapper
import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.CoffeeRepository
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.Origin
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.OriginDto
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethod
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethodDto
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.Variety
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.VarietyDto
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*
import kotlin.NoSuchElementException

@ExtendWith(MockKExtension::class)
internal class CoffeeProviderUnitTest {

    @MockK
    private lateinit var coffeeMapper: CoffeeMapper

    @MockK
    private lateinit var coffeeRepository: CoffeeRepository

    @InjectMockKs
    private lateinit var coffeeProvider: CoffeeProvider


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

    val UUID_COFFEE_1 = UUID.randomUUID()
    val UUID_COFFEE_2 = UUID.randomUUID()
    val UUID_COFFEE_3 = UUID.randomUUID()
    private val ENTITY_LIST_OF_COFFEES = listOf(
            Coffee(UUID_COFFEE_1,
                   "Coffee 1",
                   1,
                   1,
                   "Description coffee 1",
                   ENTITY_ORIGIN,
                   ENTITY_VARIETY,
                   ENTITY_PROCESS_METHOD),
            Coffee(UUID_COFFEE_2,
                   "Coffee 2",
                   2,
                   2,
                   "Description coffee 2",
                   ENTITY_ORIGIN,
                   ENTITY_VARIETY,
                   ENTITY_PROCESS_METHOD),
            Coffee(UUID_COFFEE_3,
                   "Coffee 3",
                   3,
                   3,
                   "Description coffee 3",
                   ENTITY_ORIGIN,
                   ENTITY_VARIETY,
                   ENTITY_PROCESS_METHOD)
    )
    private val DTO_LIST_OF_COFFEES = listOf(
            CoffeeDto(UUID_COFFEE_1,
                      "Coffee 1",
                      1,
                      1,
                      "Description coffee 1",
                      DTO_ORIGIN,
                      DTO_VARIETY,
                      DTO_PROCESS_METHOD),
            CoffeeDto(UUID_COFFEE_2,
                      "Coffee 2",
                      2,
                      2,
                      "Description coffee 2",
                      DTO_ORIGIN,
                      DTO_VARIETY,
                      DTO_PROCESS_METHOD),
            CoffeeDto(UUID_COFFEE_3,
                      "Coffee 3",
                      3,
                      3,
                      "Description coffee 3",
                      DTO_ORIGIN,
                      DTO_VARIETY,
                      DTO_PROCESS_METHOD)
    )

    @Test
    fun whenGetAllCoffees_ThenReturnCoffees() {
        every { coffeeMapper.entityToDtoList(any()) } returns DTO_LIST_OF_COFFEES
        every { coffeeRepository.getAll() } returns ENTITY_LIST_OF_COFFEES
        val coffeListResult = coffeeProvider.getAll()
        Assertions.assertEquals(DTO_LIST_OF_COFFEES, coffeListResult)
    }

    @Test
    fun whenGetAllCoffeesEmptyResponse_ThenReturnEmptyList() {
        every { coffeeMapper.entityToDtoList(any()) } returns emptyList()
        every { coffeeRepository.getAll() } returns emptyList()
        val coffeListResult = coffeeProvider.getAll()
        Assertions.assertTrue(coffeListResult::isEmpty)
    }

    @Test
    fun whenGetOneCoffeeWithUUID_ThenReturnCoffee() {
        every { coffeeMapper.entityToDto(any()) } returns DTO_COFFEE
        every { coffeeRepository.findByUUID(any()) } returns Optional.of(ENTITY_COFFEE)
        val result = coffeeProvider.getOne(UUID_COFFEE)
        Assertions.assertEquals(DTO_COFFEE, result)
    }

    @Test
    fun whenGetOneUnknownCoffeeWithUUID_ThenThrowNoSuchElementException() {
        every { coffeeRepository.findByUUID(any()) } returns Optional.empty()
        Assertions.assertThrows(NoSuchElementException::class.java) {
            coffeeProvider.getOne(UUID_COFFEE)
        }
    }

}