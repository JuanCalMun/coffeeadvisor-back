package com.coffeeadvisor.coffeeadvisorback.config

import com.coffeeadvisor.coffeeadvisorback.app.coffee.domain.Coffee
import com.coffeeadvisor.coffeeadvisorback.app.coffee.infrastructure.repository.CoffeeJpaRepository
import com.coffeeadvisor.coffeeadvisorback.app.origin.domain.Origin
import com.coffeeadvisor.coffeeadvisorback.app.origin.infrstructure.repository.OriginJpaRepository
import com.coffeeadvisor.coffeeadvisorback.app.process_method.domain.ProcessMethod
import com.coffeeadvisor.coffeeadvisorback.app.process_method.infrastructure.repository.ProcessMethodJpaRepository
import com.coffeeadvisor.coffeeadvisorback.app.variety.domain.Variety
import com.coffeeadvisor.coffeeadvisorback.app.variety.infrastructure.repository.VarietyJpaRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class DevDatabaseDataLoader {

    @Bean
    fun dataBaseInitializerForDevelop(
            coffeeJpaRepository: CoffeeJpaRepository,
            originJpaRepository: OriginJpaRepository,
            processMethodJpaRepository: ProcessMethodJpaRepository,
            varietyJpaRepository: VarietyJpaRepository) =
            ApplicationRunner {
                val arabigaVariety = varietyJpaRepository.save(Variety(UUID.randomUUID(), "Arabiga Bourbon"))
                val catuaiVariety = varietyJpaRepository.save(Variety(UUID.randomUUID(), "Catuai"))
                val caturraVariety = varietyJpaRepository.save(Variety(UUID.randomUUID(), "Caturra"))
                val pacasVariety = varietyJpaRepository.save(Variety(UUID.randomUUID(), "Pacas"))

                val sunProcessMethod = processMethodJpaRepository.save(
                        ProcessMethod(UUID.randomUUID(), "Wet, sun drying"))
                val wetProcessMethod = processMethodJpaRepository.save(
                        ProcessMethod(UUID.randomUUID(), "Wet"))
                val dryProcessMethod = processMethodJpaRepository.save(
                        ProcessMethod(UUID.randomUUID(), "Dry"))

                val hondurasOrigin = originJpaRepository.save(Origin(UUID.randomUUID(), "Honduras"))
                val kenyaOrigin = originJpaRepository.save(Origin(UUID.randomUUID(), "Kenya"))
                val colombiaOrigin = originJpaRepository.save(Origin(UUID.randomUUID(), "Colombia"))

                coffeeJpaRepository.save(Coffee(
                        UUID.randomUUID(),
                        "Honduras Marcala Org",
                        1200,
                        1600,
                        "This is a good coffee",
                        hondurasOrigin,
                        arabigaVariety,
                        dryProcessMethod
                ))
                coffeeJpaRepository.save(Coffee(
                        UUID.randomUUID(),
                        "Honduras Marcala",
                        1200,
                        1600,
                        "This is a very good coffee",
                        hondurasOrigin,
                        catuaiVariety,
                        wetProcessMethod
                ))
                coffeeJpaRepository.save(Coffee(
                        UUID.randomUUID(),
                        "Kenya AAA",
                        1200,
                        1600,
                        "This is a very good coffee",
                        kenyaOrigin,
                        pacasVariety,
                        sunProcessMethod
                ))
                coffeeJpaRepository.save(Coffee(
                        UUID.randomUUID(),
                        "Colombia Esmeralda",
                        1200,
                        1600,
                        "This is the best coffee",
                        colombiaOrigin,
                        caturraVariety,
                        dryProcessMethod
                ))
            }
}